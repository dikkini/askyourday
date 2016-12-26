package com.fyc.dao;

import com.fyc.dao.model.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UserAnswerDAOImpl extends GenericDAOImpl<UserAnswer, String> implements UserAnswerDAO {



    @Override
    public Collection<UserAnswer> findByMonthYear(String month, String year, User user) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);
        Join<UserAnswer, Question> questionJoin = userAnswerRoot.join(UserAnswer_.question);

        predicates.add(builder.equal(builder.treat(questionJoin, Question.class).get(Question_.month), month));
        predicates.add(builder.equal(builder.treat(questionJoin, Question.class).get(Question_.year), year));
        predicates.add(builder.equal(userAnswerRoot.get(UserAnswer_.user), user));

        criteriaQuery.select(userAnswerRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }

    @Override
    public UserAnswer findByDayMonthYear(String day, String month, String year, User user) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);
        Join<UserAnswer, Question> questionJoin = userAnswerRoot.join(UserAnswer_.question);

        predicates.add(builder.equal(builder.treat(questionJoin, Question.class).get(Question_.day), day));
        predicates.add(builder.equal(builder.treat(questionJoin, Question.class).get(Question_.month), month));
        predicates.add(builder.equal(builder.treat(questionJoin, Question.class).get(Question_.year), year));
        predicates.add(builder.equal(userAnswerRoot.get(UserAnswer_.user), user));

        criteriaQuery.select(userAnswerRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getSingleResult();
    }

    @Override
    public Collection<UserAnswer> findByUserUuid(String userUuid) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAnswer> criteriaQuery = builder.createQuery(UserAnswer.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<UserAnswer> userAnswerRoot = criteriaQuery.from(UserAnswer.class);
        Join<UserAnswer, User> userJoin = userAnswerRoot.join(UserAnswer_.user);

        predicates.add(builder.equal(builder.treat(userJoin, User.class).get(User_.uuid), userUuid));

        criteriaQuery.select(userAnswerRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<UserAnswer> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }
}
