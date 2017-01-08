package com.askyourday.controller;

import com.askyourday.controller.model.UserDTO;
import com.askyourday.dao.model.Privilege;
import com.askyourday.dao.model.Role;
import com.askyourday.dao.model.User;
import com.askyourday.exception.EmailExistException;
import com.askyourday.exception.UsernameExistException;
import com.askyourday.service.UserService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class LoginSignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    @GetMapping
    @RequestMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("main/login");
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

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            for (final Privilege privilege : role.getPrivileges()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }

        Authentication auth =
                new UsernamePasswordAuthenticationToken(user, null, grantedAuthorities);

        SecurityContextHolder.getContext().setAuthentication(auth);

        return new ModelAndView("redirect:/calendar");
    }
}
