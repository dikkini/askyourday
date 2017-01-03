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
public class QuestionTranslationDAOImpl extends GenericDAOImpl<QuestionTranslation, Long> implements QuestionTranslationDAO {

    @Override
    public Collection<QuestionTranslation> findByMonthYear(String month, String year, String locale) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<QuestionTranslation> criteriaQuery = builder.createQuery(QuestionTranslation.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<QuestionTranslation> questionTranslationRoot = criteriaQuery.from(QuestionTranslation.class);
        Join<QuestionTranslation, Question> questionJoin = questionTranslationRoot.join(QuestionTranslation_.question, JoinType.LEFT);

        predicates.add(builder.equal(questionJoin.get(Question_.month), month));
        predicates.add(builder.equal(questionJoin.get(Question_.year), year));
        predicates.add(builder.equal(questionTranslationRoot.get(QuestionTranslation_.language), locale));

        criteriaQuery.select(questionTranslationRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<QuestionTranslation> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }

    @Override
    public QuestionTranslation findByDayMonthYear(String day, String month, String year, String locale) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<QuestionTranslation> criteriaQuery = builder.createQuery(QuestionTranslation.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<QuestionTranslation> questionTranslationRoot = criteriaQuery.from(QuestionTranslation.class);
        Join<QuestionTranslation, Question> questionJoin = questionTranslationRoot.join(QuestionTranslation_.question, JoinType.LEFT);

        predicates.add(builder.equal(questionJoin.get(Question_.day), day));
        predicates.add(builder.equal(questionJoin.get(Question_.month), month));
        predicates.add(builder.equal(questionJoin.get(Question_.year), year));
        predicates.add(builder.equal(questionTranslationRoot.get(QuestionTranslation_.language), locale));

        criteriaQuery.select(questionTranslationRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<QuestionTranslation> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getSingleResult();
    }
}
