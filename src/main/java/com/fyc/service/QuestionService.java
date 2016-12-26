package com.fyc.service;


import com.fyc.dao.model.Question;

import java.util.Collection;

public interface QuestionService {

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    Question findByDayMonthYear(String day, String month, String year);

    /**
     *
     * @param month
     * @param year
     * @return
     */
    Collection<Question> findByMonthYear(String month, String year);
}
