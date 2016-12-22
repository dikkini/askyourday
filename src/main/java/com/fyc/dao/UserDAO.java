package com.fyc.dao;

import com.fyc.dao.model.User;

import javax.persistence.NoResultException;

public interface UserDAO {

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
