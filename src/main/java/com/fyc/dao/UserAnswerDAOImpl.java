package com.fyc.dao;

import com.fyc.dao.model.*;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collection;

@Repository
public class UserAnswerDAOImpl extends GenericDAOImpl<UserAnswer, String> implements UserAnswerDAO {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Collection<UserAnswer> findByMonthYear(String month, String year, User user) {
        logger.debug("DAO method findByMonthYear");

        EntityManager em = sessionFactory.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);
        Join<UserAnswer, Question> questionJoin = userAnswerRoot.join(UserAnswer_.question);

        Predicate userEq = builder.equal(userAnswerRoot.get(UserAnswer_.user), user);
        Predicate monthEq = builder.equal(builder.treat(questionJoin, Question.class).get(Question_.month), month);
        Predicate yearEq = builder.equal(builder.treat(questionJoin, Question.class).get(Question_.year), year);

        criteriaQuery.select(userAnswerRoot).where(userEq, monthEq, yearEq);

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }

    @Override
    public UserAnswer findByDayMonthYear(String day, String month, String year, User user) {
        logger.debug("DAO method findByDayMonthYear");

        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);
        Join<UserAnswer, Question> questionJoin = userAnswerRoot.join(UserAnswer_.question);

        Predicate userEq = builder.equal(userAnswerRoot.get(UserAnswer_.user), user);
        Predicate dayEq = builder.equal(builder.treat(questionJoin, Question.class).get(Question_.day), day);
        Predicate monthEq = builder.equal(builder.treat(questionJoin, Question.class).get(Question_.month), month);
        Predicate yearEq = builder.equal(builder.treat(questionJoin, Question.class).get(Question_.year), year);

        criteriaQuery.select(userAnswerRoot).where(userEq, dayEq, monthEq, yearEq);

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getSingleResult();
    }

    @Override
    public Collection<UserAnswer> findByUserUuid(String userUuid) {
        logger.debug("DAO method findByUserUuid");

        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);

        Predicate userEq = builder.equal(userAnswerRoot.get(UserAnswer_.user), userUuid);

        criteriaQuery.select(userAnswerRoot).where(userEq);

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }
}
