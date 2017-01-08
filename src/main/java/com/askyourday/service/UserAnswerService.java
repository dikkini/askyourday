package com.askyourday.service;


import com.askyourday.controller.model.UserAnswerDTO;
import com.askyourday.dao.model.User;
import com.askyourday.dao.model.UserAnswer;

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
     * @param userAnswerUuid
     * @param answerText
     * @return
     */
    UserAnswer update(String userAnswerUuid, String answerText);

    /**
     *
     * @param month
     * @param year
     * @param user
     * @return
     */
    Collection<UserAnswer> findByMonthYear(String month, String year, User user);
}
