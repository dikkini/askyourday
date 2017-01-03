package com.fyc.dao;

import com.fyc.dao.model.QuestionTranslation;

import java.util.Collection;

public interface QuestionTranslationDAO extends GenericDAO<QuestionTranslation, Long> {

    /**
     *
     * @param month
     * @param year
     * @param locale
     * @return
     */
    Collection<QuestionTranslation> findByMonthYear(String month, String year, String locale);

    /**
     *
     * @param day
     * @param month
     * @param year
     * @param locale
     * @return
     */
    QuestionTranslation findByDayMonthYear(String day, String month, String year, String locale);
}
