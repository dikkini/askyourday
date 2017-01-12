package com.askyourday.controller;

import com.askyourday.controller.model.UserDTO;
import com.askyourday.controller.model.VKAuthResponse;
import com.askyourday.dao.model.Privilege;
import com.askyourday.dao.model.Role;
import com.askyourday.dao.model.User;
import com.askyourday.exception.EmailExistException;
import com.askyourday.exception.InternalErrorException;
import com.askyourday.exception.UsernameExistException;
import com.askyourday.service.UserService;
import com.askyourday.utils.ApplicationConstants;
import com.askyourday.utils.Utils;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class LoginSignupController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    @GetMapping
    @RequestMapping("/login")
    public ModelAndView loginPage(@RequestParam(required = false, value = "social") String social,
                                  HttpServletResponse response, HttpServletRequest request) {

        // TODO enum for social types
        // TODO seperate jar for social auth

        if (social != null && social.equals("fb")) {
            String hashFacebookAuth = Utils.getHashFacebookAuth(RandomStringUtils.randomAlphabetic(10));
            request.getSession().setAttribute(ApplicationConstants.FACEBOOK_KEY_WORD, hashFacebookAuth);

            String url = "https://www.facebook.com/dialog/oauth/?"
                    + "client_id=" + ApplicationConstants.FACEBOOK_APP_ID
                    + "&redirect_uri=" + ApplicationConstants.FACEBOOK_REDIRECT_URL + hashFacebookAuth
                    + "&scope=public_profile,email"
                    + "&state=" + ApplicationConstants.FACEBOOK_EXCHANGE_KEY
                    + "&display=page"
                    + "&response_type=code";
            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
                throw new InternalErrorException("Facebook Login Error",
                        ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE);
            }
        } else if (social != null && social.equals("vk")) {
            try {
                response.sendRedirect("https://oauth.vk.com/authorize?client_id=" + "5818054" + "&scope=" + "email" + "&redirect_uri=https://askyourday.com/login/vk&response_type=code&v=5.62");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (social != null && social.equals("tw")) {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer("7aF2vzTm2IkWeW4DbC6G9sCCm", "1n8pHOWsDJcREFlHr0eUYysaHLmUjpWu4oKkFiCwIGNvJoKcvZ");
            request.getSession().setAttribute("twitter", twitter);
            try {
                String callbackURL = "https://askyourday.com/login/twitter";

                RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL);
                request.getSession().setAttribute("requestToken", requestToken);
                response.sendRedirect(requestToken.getAuthenticationURL());

            } catch (TwitterException | IOException e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("main/login");
    }

    @GetMapping
    @RequestMapping("/login/twitter")
    public String loginTwitter(@RequestParam(required = true, value = "oauth_verifier") String verifier,
                               @RequestParam(required = true, value = "oauth_token") String token,
                               HttpServletResponse response, HttpServletRequest request) {
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        try {
            AccessToken oAuthAccessToken = twitter.getOAuthAccessToken(requestToken, verifier);
            String screenName = twitter.getScreenName();
            long id = twitter.getId();
            request.getSession().removeAttribute("requestToken");
            // TODO check existing user by id, register user, auth user
            User bySocialId = userService.findBySocialId(String.valueOf(id));

            if (bySocialId != null) {
                authentificateUser(bySocialId);
            } else {
                User user = userService.registerSocialUser(null, String.valueOf(id), null, null, null, 3);
                authentificateUser(user);
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return "redirect:/calendar";
    }

    @GetMapping
    @RequestMapping("/login/vk")
    public String loginVK(@RequestParam(required = false, value = "code") String code,
                               HttpServletResponse response, HttpServletRequest request) {
        try {
            TransportClient transportClient = HttpTransportClient.getInstance();
            VkApiClient vk = new VkApiClient(transportClient, new Gson());
            String textResponse = vk.oauth().userAuthorizationCodeFlow(5818054, "zGNReBHxD2920LtZnYEy", "https://askyourday.com/login/vk", code).executeAsString();

            JsonReader jsonReader = new JsonReader(new StringReader(textResponse));
            JsonObject json = (JsonObject)(new JsonParser()).parse(jsonReader);
            if (json.has("error")) {
                // TODO
                return "redirect:/login?error_message=We can't login you using vkontakte. Please choose other method.";
            }

            VKAuthResponse vkAuthResponse;
            try {
                vkAuthResponse = new Gson().fromJson(json, VKAuthResponse.class);
            } catch (JsonSyntaxException var8) {
                logger.error("Invalid JSON: " + textResponse, var8);
                throw new ClientException("Can\'t parse json response");
            }

            String email = vkAuthResponse.getEmail();
            Integer userId = vkAuthResponse.getUserId();

            User bySocialId = userService.findBySocialId(userId.toString());

            if (email != null) {
                User byEmail = userService.findByEmail(email);
                if (byEmail != null && bySocialId != null) {
                    if (byEmail.getSocialId().equals(bySocialId.getSocialId())) {
                        authentificateUser(bySocialId);
                    } else {
                        return "redirect:/login?error_code=123&error_message=Email is busy";
                    }
                } else {
                    User user = userService.registerSocialUser(null, userId.toString(), null, null, email, 3);
                    authentificateUser(user);
                }
            } else {
                if (bySocialId != null) {
                    authentificateUser(bySocialId);
                } else {
                    User user = userService.registerSocialUser(null, userId.toString(), null, null, null, 3);
                    authentificateUser(user);
                }
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "redirect:/calendar";
    }

    @GetMapping
    @RequestMapping("/login/facebook")
    public String loginFacebook(@RequestParam(required = false, value = "authCode") String authCode,
                                @RequestParam(required = false, value = "error_code") String fbErrCode,
                                @RequestParam(required = false, value = "error_message") String fbErrMsg,
                                HttpServletResponse response, HttpServletRequest request) {

        if (fbErrCode != null) {
            return "redirect:/login?error_message=" + fbErrMsg;
        }

        // internal test
        String hashFacebookAuth = (String) request.getSession().getAttribute(ApplicationConstants.FACEBOOK_KEY_WORD);
        if (!hashFacebookAuth.equals(authCode)) {
            throw new InternalErrorException("Facebook login error",
                    ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE);
        }
        //Get the parameter "code" from the request
        String code = request.getParameter("code");
        //Check if its null or blank or empty
        if (StringUtils.isNotEmpty(code)) {
            //If we received a valid code, we can continue to the next step
            //Next we want to get the access_token from Facebook using the code we got,
            //use the following url for that, in this url,
            //client_id-our app id(same as above),  redirect_uri-same as above, client_secret-same as
            // above, code-the code we just got
            String url = "https://graph.facebook.com/oauth/access_token?"
                    + "client_id=" + ApplicationConstants.FACEBOOK_APP_ID
                    + "&redirect_uri=" + ApplicationConstants.FACEBOOK_REDIRECT_URL + hashFacebookAuth
                    + "&client_secret=" + ApplicationConstants.FACEBOOK_SECRET_KEY
                    + "&code=" + code;
            // Create an instance of HttpClient.
            HttpClient client = new HttpClient();
            // Create a method instance.
            GetMethod method = new GetMethod(url);
            // Provide custom retry handler is necessary
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));
            try {
                // Execute the method.
                int statusCode = client.executeMethod(method);
                byte[] responseBody = method.getResponseBody();
                String responseBodyString = new String(responseBody);
                if (statusCode != HttpStatus.SC_OK) {
                    System.err.println("ResponseBody: " + responseBodyString);
                    throw new InternalErrorException("Facebook login error",
                            ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE);
                }
                //will be like below,
                // access_token=AAADD1QFhDlwBADrKkn87ZABAz6ZCBQZ//DZD&expires=5178320
                //now get the access_token from the response
                if (responseBodyString.contains("access_token")) {
                    //success
                    String[] mainResponseArray = responseBodyString.split("&");
                    //like
                    // {"access_token= AAADD1QFhDlwBADrKkn87ZABAz6ZCBQZ//DZD ","expires=5178320"}
                    String accesstoken = "";
                    for (String string : mainResponseArray) {
                        if (string.contains("access_token")) {
                            accesstoken = string.replace("access_token=", "").trim();
                        }
                    }
                    //Great. Now we have the access token, I have used restfb to get the user details here
                    FacebookClient facebookClient = new DefaultFacebookClient(accesstoken, Version.LATEST);

                    // TODO сделать проверку на валидность юзера
                    com.restfb.types.User facebookUser = facebookClient.fetchObject("me", com.restfb.types.User.class,
                            Parameter.with("fields", "id,email,first_name,last_name,name,locale,name_format"));
                    String firstName = facebookUser.getFirstName();
                    String lastName = facebookUser.getLastName();
                    String email = facebookUser.getEmail();
                    String id = facebookUser.getId();

                    String username = email.split("@")[0];

                    // Release the connection.
                    method.releaseConnection();

                    User byEmail = userService.findByEmail(email);
                    if (byEmail != null) {
                        String byEmailUsername = byEmail.getUsername();
                        if (!byEmailUsername.equals(username)) {
                            return "redirect:/login?error_code=" + ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE + "&error_message=" + "Username or Email is busy";
                        } else {
                            authentificateUser(byEmail);
                            return "redirect:/calendar";
                        }
                    } else {
                        User byUsername = userService.findByUsername(username);
                        if (byUsername != null) {
                            return "redirect:/login?error_code=" + ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE + "&error_message=" + "Username is busy";
                        } else {
                            User user = userService.registerSocialUser(username, id, firstName, lastName, email, 1);
                            authentificateUser(user);
                            return "redirect:/calendar";
                        }
                    }

                } else {
                    return "redirect:/login?error_code=" + ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE + "&error_message=" + "Facebook error login";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Common Exception: " + e.getMessage());
                return "redirect:/login?error_code=" + ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE + "&error_message=" + "Facebook error login";
            }
        }
        return "redirect:/login?error_code=" + ApplicationConstants.FACEBOOK_LOGIN_EXCEPTION_MESSAGE + "&error_message=Facebook error login.";
    }

    @GetMapping
    @RequestMapping("/signup")
    public ModelAndView signupPage() {
        ModelAndView mav = new ModelAndView("main/signup");
        mav.addObject("registerUser", new UserDTO());
        return mav;
    }

    @PostMapping(value = "/signup")
    public ModelAndView signupAction(@Valid @ModelAttribute("registerUser") UserDTO userDTO, BindingResult result) {
        int errorCount = result.getErrorCount();

        User user;
        if (errorCount == 0) {
            try {
                user = userService.registerUser(userDTO);
            } catch (UsernameExistException e) {
                ModelAndView mav = new ModelAndView();
                mav.setViewName("main/signup");
                mav.addObject("registerUser", userDTO);
                mav.addObject("SIGNUP_ERROR", context.getMessage("UsernameExistException", null, LocaleContextHolder.getLocale()));
                return mav;
            } catch (EmailExistException e) {
                ModelAndView mav = new ModelAndView();
                mav.setViewName("main/signup");
                mav.addObject("registerUser", userDTO);
                mav.addObject("SIGNUP_ERROR", context.getMessage("EmailExistException", null, LocaleContextHolder.getLocale()));
                return mav;
            }
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("main/signup");
            mav.addObject("SIGNUP_ERROR", "ERROR");
            mav.addObject("registerUser", userDTO);
            return mav;
        }

        authentificateUser(user);

        return new ModelAndView("redirect:/calendar");
    }

    private void authentificateUser(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            for (final Privilege privilege : role.getPrivileges()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }

        Authentication auth =
                new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities);

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
