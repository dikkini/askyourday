package com.askyourday.controller;

import com.askyourday.controller.model.GenericResponse;
import com.askyourday.controller.model.UserAnswerDTO;
import com.askyourday.dao.model.QuestionTranslation;
import com.askyourday.dao.model.User;
import com.askyourday.dao.model.UserAnswer;
import com.askyourday.service.QuestionService;
import com.askyourday.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

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
                                         @RequestParam(value = "year") String year,
                                         @RequestParam(value = "timezone") String timezoneStr) {

        int timeZone = Integer.parseInt(timezoneStr);
        if (timeZone >= 0) {
            timezoneStr = "+" + timeZone;
        }

        TimeZone tz = TimeZone.getTimeZone("GMT" + timezoneStr);

        Calendar c = Calendar.getInstance();
        c.setTimeZone(tz);
        c.set(Integer.valueOf(year), Integer.valueOf(month) - 1, Integer.valueOf(day), 0, 0);
        long timeInMillis = c.getTimeInMillis();

        long now = new Date().getTime();

        if (timeInMillis > now) {
            return ResponseEntity.ok(GenericResponse.createResponse(false));
        }


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
