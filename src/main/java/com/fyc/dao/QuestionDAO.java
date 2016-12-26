package com.fyc.dao;

import com.fyc.dao.model.Question;

import java.util.Collection;

public interface QuestionDAO {
    /**
     *
     * @param month
     * @param year
     * @return
     */
    Collection<Question> findByMonthYear(String month, String year);

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    Question findByDayMonthYear(String day, String month, String year);
}
