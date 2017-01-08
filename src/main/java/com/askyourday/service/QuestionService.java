package com.askyourday.service;


import com.askyourday.dao.model.QuestionTranslation;

import java.util.Collection;

public interface QuestionService {

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    QuestionTranslation findByDayMonthYear(String day, String month, String year);

    /**
     *
     * @param month
     * @param year
     * @return
     */
    Collection<QuestionTranslation> findByMonthYear(String month, String year);
}
