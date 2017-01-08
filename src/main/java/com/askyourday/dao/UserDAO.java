package com.askyourday.dao;

import com.askyourday.dao.model.User;

import javax.persistence.NoResultException;

public interface UserDAO extends GenericDAO<User, String> {

    /**
     * Поиск пользователя по username
     *
     * @param username username
     * @return модель пользователя с деталями
     */
    User findByUsername(String username) throws NoResultException;

    /**
     * Поиск пользователя по email
     *
     * @param email email
     * @return
     */
    User findByEmail(String email) throws NoResultException;

}
