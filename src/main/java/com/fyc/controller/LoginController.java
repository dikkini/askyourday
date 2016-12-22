package com.fyc.controller;

import com.fyc.controller.model.GenericResponse;
import com.fyc.controller.model.UserDTO;
import com.fyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    public ModelAndView signupAction(@Valid UserDTO userDTO, BindingResult result) {
        int errorCount = result.getErrorCount();

        if (errorCount == 0) {
            userService.create(userDTO);
        }

        return new ModelAndView("main/index");
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
