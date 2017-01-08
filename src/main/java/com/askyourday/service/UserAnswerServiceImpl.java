package com.askyourday.service;

import com.askyourday.controller.model.UserAnswerDTO;
import com.askyourday.dao.QuestionDAO;
import com.askyourday.dao.UserAnswerDAO;
import com.askyourday.dao.model.Question;
import com.askyourday.dao.model.User;
import com.askyourday.dao.model.UserAnswer;
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
        String answerText = userAnswerDTO.getAnswerText();
        Long questionId = userAnswerDTO.getQuestionId();

        Question questionTranslation = questionDAO.findOne(Question.class, questionId);

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setAnswer(answerText);
        userAnswer.setQuestion(questionTranslation);

        return questionDAO.create(userAnswer);
    }

    @Override
    @Transactional
    public UserAnswer update(String userAnswerUuid, String answerText) {

        UserAnswer userAnswer = userAnswerDAO.findOne(UserAnswer.class, userAnswerUuid);
        userAnswer.setAnswer(answerText);

        return userAnswerDAO.update(userAnswer);
    }
}
