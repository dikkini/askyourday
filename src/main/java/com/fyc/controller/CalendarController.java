package com.fyc.controller;

import com.fyc.controller.model.GenericResponse;
import com.fyc.dao.model.Question;
import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;
import com.fyc.service.QuestionService;
import com.fyc.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ModelAndView calendarPage() {
        ModelAndView mav = new ModelAndView("main/calendar");
        return mav;
    }

    @GetMapping(value = "/getQuestionByDayMonthYear")
    public ResponseEntity getQuestionByDayMonthYear(@RequestParam(value = "day") String day,
                                                    @RequestParam(value = "month") String month,
                                                    @RequestParam(value = "year") String year) {
        Question byDayMonthYear = questionService.findByDayMonthYear(day, month, year);
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }

    @GetMapping(value = "/getUserAnswerByDayMonthYear")
    public ResponseEntity getUserAnswerByDayMonthYear(@RequestParam(value = "day") String day,
                                                      @RequestParam(value = "month") String month,
                                                      @RequestParam(value = "year") String year, Authentication authentication) {
        UserAnswer byDayMonthYear = userAnswerService.findByDayMonthYear(day, month, year, (User) authentication.getPrincipal());
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }

    @GetMapping(value = "/getMyUserAnswersByMonthYear")
    public ResponseEntity getMyUserAnswersByMonthYear(@RequestParam(value = "month") String month,
                                                    @RequestParam(value = "year") String year, Authentication authentication) {
        Collection<UserAnswer> byDayMonthYear = userAnswerService.findByMonthYear(month, year, (User) authentication.getPrincipal());
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }

    @GetMapping(value = "/getUserAnswersByMonthYear")
    public ResponseEntity getUserAnswersByMonthYear(@RequestParam(value = "month") String month,
                                                    @RequestParam(value = "year") String year,
                                                    @RequestParam(value = "userUuid") String userUuid) {
        Collection<UserAnswer> byDayMonthYear = userAnswerService.findByMonthYear(month, year, userUuid);
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }
}
