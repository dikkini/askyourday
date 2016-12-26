package com.fyc.service;

import com.fyc.dao.GenericDAO;
import com.fyc.dao.QuestionDAO;
import com.fyc.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collection;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    @Qualifier(value = "genericDAOImpl")
    private GenericDAO<Question, Long> genericDAO;

    @Override
    public Question findByDayMonthYear(String day, String month, String year) {
        Question byDayMonthYear;
        try {
            byDayMonthYear = questionDAO.findByDayMonthYear(day, month, year);
        } catch (NoResultException e) {
            byDayMonthYear = null;
        }
        return byDayMonthYear;
    }

    @Override
    public Collection<Question> findByMonthYear(String month, String year) {
        Collection<Question> byMonthYear = questionDAO.findByMonthYear(month, year);
        return byMonthYear;
    }
}
