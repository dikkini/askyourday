package com.askyourday.dao;

import com.askyourday.dao.model.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class QuestionDAOImpl extends GenericDAOImpl<Question, Long> implements QuestionDAO {



    @Override
    public Collection<Question> findByMonthYear(String month, String year, String locale) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = builder.createQuery(Question.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<Question> questionRoot = criteriaQuery.from(Question.class);
        ListJoin<Question, QuestionTranslation> questionTranslationJoinRoot = questionRoot.join(Question_.questionTranslation, JoinType.LEFT);

        predicates.add(builder.equal(questionRoot.get(Question_.month), month));
        predicates.add(builder.equal(questionRoot.get(Question_.year), year));
        predicates.add(builder.equal(questionTranslationJoinRoot.get(QuestionTranslation_.language), locale));

        criteriaQuery.select(questionRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Question> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }

    @Override
    public Question findByDayMonthYear(String day, String month, String year, String locale) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = builder.createQuery(Question.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<Question> questionRoot = criteriaQuery.from(Question.class);
        ListJoin<Question, QuestionTranslation> questionTranslationJoinRoot = questionRoot.join(Question_.questionTranslation, JoinType.LEFT);

        predicates.add(builder.equal(questionRoot.get(Question_.day), day));
        predicates.add(builder.equal(questionRoot.get(Question_.month), month));
        predicates.add(builder.equal(questionRoot.get(Question_.year), year));
        predicates.add(builder.equal(questionTranslationJoinRoot.get(QuestionTranslation_.language), locale));

        criteriaQuery.select(questionRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Question> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getSingleResult();
    }
}
