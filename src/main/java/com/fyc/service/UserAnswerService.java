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
     * @param month
     * @param year
     * @param user
     * @return
     */
    Collection<UserAnswer> findByMonthYear(String month, String year, User user);
}
