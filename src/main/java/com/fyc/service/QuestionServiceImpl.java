package com.fyc.service;

import com.fyc.dao.QuestionTranslationDAO;
import com.fyc.dao.model.QuestionTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionTranslationDAO questionTranslationDAO;

    @Override
    public QuestionTranslation findByDayMonthYear(String day, String month, String year) {
        String language = LocaleContextHolder.getLocale().getLanguage();
        QuestionTranslation byDayMonthYear = questionTranslationDAO.findByDayMonthYear(day, month, year, language);
        return byDayMonthYear;
    }

    @Override
    public Collection<QuestionTranslation> findByMonthYear(String month, String year) {
        String language = LocaleContextHolder.getLocale().getLanguage();
        Collection<QuestionTranslation> byMonthYear = questionTranslationDAO.findByMonthYear(month, year, language);
        return byMonthYear;
    }
}
