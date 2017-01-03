package com.fyc.dao;

import com.fyc.dao.model.Question;

import java.util.Collection;

public interface QuestionDAO extends GenericDAO<Question, Long> {
    /**
     *
     * @param month
     * @param year
     * @param locale
     * @return
     */
    Collection<Question> findByMonthYear(String month, String year, String locale);

    /**
     *
     * @param day
     * @param month
     * @param year
     * @param locale
     * @return
     */
    Question findByDayMonthYear(String day, String month, String year, String locale);
}
