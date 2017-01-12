package com.askyourday.dao;

import com.askyourday.dao.model.User;
import com.askyourday.dao.model.User_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO {



    @Override
    public User findByUsername(String username) throws NoResultException {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot);
        criteriaQuery.where(builder.equal(userRoot.get(User_.username), username));
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User findByEmail(String email) throws NoResultException {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot);
        criteriaQuery.where(builder.equal(userRoot.get(User_.email), email));
        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User findBySocialId(String socialId) throws NoResultException {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot);
        criteriaQuery.where(builder.equal(userRoot.get(User_.socialId), socialId));
        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
