package com.fyc.dao;

import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;

import java.util.Collection;

public interface UserAnswerDAO extends GenericDAO<UserAnswer, String> {

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
     * @param day
     * @param month
     * @param year
     * @param user
     * @return
     */
    UserAnswer findByDayMonthYear(String day, String month, String year, User user);

    /**
     *
     * @param userUuid
     * @return
     */
    Collection<UserAnswer> findByUserUuid(String userUuid);
}
