package com.fyc.service;

import com.fyc.controller.model.UserAnswerDTO;
import com.fyc.dao.QuestionDAO;
import com.fyc.dao.UserAnswerDAO;
import com.fyc.dao.model.Question;
import com.fyc.dao.model.User;
import com.fyc.dao.model.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerDAO userAnswerDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public Collection<UserAnswer> findByMonthYear(String month, String year, User user) {
        Collection<UserAnswer> byMonthYear = userAnswerDAO.findByMonthYear(month, year, user);
        return byMonthYear;
    }

    @Override
    @Transactional
    public UserAnswer create(UserAnswerDTO userAnswerDTO) {
        User user = userAnswerDTO.getUser();
        String answer = userAnswerDTO.getAnswer();
        Long questionId = userAnswerDTO.getQuestionId();

        Question questionTranslation = questionDAO.findOne(Question.class, questionId);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setAnswer(answer);
        userAnswer.setQuestion(questionTranslation);

        return questionDAO.create(userAnswer);
    }

    @Override
    @Transactional
    public UserAnswer update(UserAnswer userAnswer) {
        return userAnswerDAO.update(userAnswer);
    }
}
