package com.fyc.service;


import com.fyc.controller.model.UserAnswerDTO;
import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;

import java.util.Collection;

public interface UserAnswerService {

    /**
     *
     * @param userAnswerDTO
     * @return
     */
    UserAnswer create(final UserAnswerDTO userAnswerDTO);

    /**
     *
     * @param userAnswer
     * @return
     */
    UserAnswer update(final UserAnswer userAnswer);

    /**
     *
     * @param day
     * @param month
     * @param year
     * @param user
     * @return
     */
    UserAnswer findByDayMonthYear(String day, String month, String year, User user);

    /**
     *
     * @param month
     * @param year
     * @param user
     * @return
     */
    Collection<UserAnswer> findByMonthYear(String month, String year, User user);

    /**
     *
     * @param month
     * @param year
     * @param userUuid
     * @return
     */
    Collection<UserAnswer> findByMonthYear(String month, String year, String userUuid);
}
