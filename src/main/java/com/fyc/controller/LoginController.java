package com.fyc.controller;

import com.fyc.controller.model.GenericResponse;
import com.fyc.controller.model.UserDTO;
import com.fyc.dao.model.Privilege;
import com.fyc.dao.model.Role;
import com.fyc.dao.model.User;
import com.fyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView loginPage() {
        return new ModelAndView("main/login");
    }

    @PostMapping(value = "/signup")
    public ModelAndView signupAction(@Valid UserDTO userDTO, BindingResult result) {
        int errorCount = result.getErrorCount();

        User user;
        if (errorCount == 0) {
            user = userService.create(userDTO);
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("main/login");
            mav.addObject("SIGNUP_ERROR", "ERROR");
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

    @PostMapping(value = "/isUsernameBusy")
    public ResponseEntity isUsernameBusy(@RequestParam(value = "username") String username) {
        boolean usernameBusy = userService.isUsernameBusy(username);
        return ResponseEntity.ok(GenericResponse.createResponse(usernameBusy));
    }

    @PostMapping(value = "/isEmailBusy")
    public ResponseEntity isEmailBusy(@RequestParam(value = "email") String email) {
        boolean emailBusy = userService.isEmailBusy(email);
        return ResponseEntity.ok(GenericResponse.createResponse(emailBusy));
    }
}
