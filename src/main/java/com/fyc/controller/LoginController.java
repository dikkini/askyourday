package com.fyc.controller;

import com.fyc.controller.model.UserDTO;
import com.fyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * akarapetov
 * com.fyc.controller
 * fycapp
 * 22.12.2016
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("main/login");
        return mav;
    }

    @PostMapping(value = "/signup")
    public ModelAndView signupAction(@Valid UserDTO UserDTO, BindingResult result) {
        int errorCount = result.getErrorCount();

        if (errorCount == 0) {
            userService.create(UserDTO);
        }

        return new ModelAndView("main/index");
    }

    @PostMapping(value = "/isUsernameBusy")
    public @ResponseBody ResponseEntity isUsernameBusy(@RequestParam(value = "username") String username) {
        return ResponseEntity.ok(userService.isUsernameBusy(username));
    }

    @PostMapping(value = "/isEmailBusy")
    public @ResponseBody ResponseEntity isEmailBusy(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok(userService.isEmailBusy(email));
    }
}
