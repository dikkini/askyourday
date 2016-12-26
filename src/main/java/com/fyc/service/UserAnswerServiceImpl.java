package com.fyc.service;

import com.fyc.controller.model.UserAnswerDTO;
import com.fyc.dao.GenericDAO;
import com.fyc.dao.UserAnswerDAO;
import com.fyc.dao.model.Question;
import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerDAO userAnswerDAO;

    @Autowired
    private GenericDAO<User, String> genericUserDAO;

    @Autowired
    @Qualifier(value = "genericDAOImpl")
    private GenericDAO<UserAnswer, String> genericDAO;

    @Override
    public UserAnswer findByDayMonthYear(String day, String month, String year, User user) {
        UserAnswer byDayMonthYear = userAnswerDAO.findByDayMonthYear(day, month, year, user);
        return byDayMonthYear;
    }

    @Override
    public Collection<UserAnswer> findByMonthYear(String month, String year, User user) {
        Collection<UserAnswer> byMonthYear = userAnswerDAO.findByMonthYear(month, year, user);
        return byMonthYear;
    }

    @Override
    public Collection<UserAnswer> findByMonthYear(String month, String year, String userUuid) {
        User user = genericUserDAO.findOne(User.class, userUuid);
        Collection<UserAnswer> byMonthYear = this.findByMonthYear(month, year, user);
        return byMonthYear;
    }

    @Override
    @Transactional
    public UserAnswer create(UserAnswerDTO userAnswerDTO) {
        User user = userAnswerDTO.getUser();
        Long questionId = userAnswerDTO.getQuestionId();
        String questionStr = userAnswerDTO.getQuestion();
        String day = userAnswerDTO.getDay();
        String month = userAnswerDTO.getMonth();
        String year = userAnswerDTO.getYear();
        String answer = userAnswerDTO.getAnswer();

        Question question = new Question();
        question.setId(questionId);
        question.setQuestion(questionStr);
        question.setDay(day);
        question.setMonth(month);
        question.setYear(year);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setAnswer(answer);
        userAnswer.setQuestion(question);

        return genericDAO.create(userAnswer);
    }

    @Override
    @Transactional
    public UserAnswer update(UserAnswer userAnswer) {
        return genericDAO.update(userAnswer);
    }
}
