package com.fyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

    @GetMapping
    public ModelAndView calendarPage() {
        ModelAndView mav = new ModelAndView("main/calendar");
        return mav;
    }
}
