package com.askyourday.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @GetMapping(value = "/")
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView("main/index");
        return mav;
    }
}
