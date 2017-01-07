package com.fyc.controller;

import com.fyc.controller.model.GenericResponse;
import com.fyc.controller.model.UserAnswerDTO;
import com.fyc.dao.model.QuestionTranslation;
import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;
import com.fyc.service.QuestionService;
import com.fyc.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/getDayQuestion")
    public ResponseEntity getDayQuestion(@RequestParam(value = "day") String day,
                                         @RequestParam(value = "month") String month,
                                         @RequestParam(value = "year") String year) {
        QuestionTranslation byDayMonthYear = questionService.findByDayMonthYear(day, month, year);
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }

    @GetMapping(value = "/getMonthUserAnswers")
    public ResponseEntity getMonthUserAnswers(@RequestParam(value = "month") String month,
                                              @RequestParam(value = "year") String year,
                                              Authentication authentication) {
        Collection<UserAnswer> byDayMonthYear = userAnswerService.findByMonthYear(month, year,
                (User) authentication.getPrincipal());
        return ResponseEntity.ok(GenericResponse.createResponse(true, byDayMonthYear));
    }

    @PostMapping(value = "/saveUserAnswer")
    public ResponseEntity saveUserAnswer(@ModelAttribute("userAnswerDTO") UserAnswerDTO userAnswerDTO,
                                         Authentication authentication) {
        userAnswerDTO.setUser((User) authentication.getPrincipal());
        UserAnswer userAnswer = userAnswerService.create(userAnswerDTO);
        return ResponseEntity.ok(GenericResponse.createResponse(true));
    }

    @PostMapping(value = "/updateUserAnswer")
    public ResponseEntity updateUserAnswer(@RequestParam(value = "userAnswerUuid") String userAnswerUuid,
                                           @RequestParam(value = "answerText") String answerText) {
        userAnswerService.update(userAnswerUuid, answerText);
        return ResponseEntity.ok(GenericResponse.createResponse(true));
    }
}
