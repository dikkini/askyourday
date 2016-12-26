package com.fyc.dao;

import com.fyc.dao.model.Question;
import com.fyc.dao.model.Question_;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class QuestionDAOImpl extends GenericDAOImpl<Question, Long> implements QuestionDAO {



    @Override
    public Collection<Question> findByMonthYear(String month, String year) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = builder.createQuery(Question.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<Question> questionRoot = criteriaQuery.from(Question.class);

        predicates.add(builder.equal(questionRoot.get(Question_.month), month));
        predicates.add(builder.equal(questionRoot.get(Question_.year), year));

        criteriaQuery.select(questionRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Question> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getResultList();
    }

    @Override
    public Question findByDayMonthYear(String day, String month, String year) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = builder.createQuery(Question.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<Question> questionRoot = criteriaQuery.from(Question.class);

        predicates.add(builder.equal(questionRoot.get(Question_.day), day));
        predicates.add(builder.equal(questionRoot.get(Question_.month), month));
        predicates.add(builder.equal(questionRoot.get(Question_.year), year));

        criteriaQuery.select(questionRoot).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Question> query = em.createQuery(criteriaQuery);

        String queryString = query.unwrap(Query.class).getQueryString();

        return query.getSingleResult();
    }
}
