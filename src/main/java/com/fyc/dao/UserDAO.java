package com.fyc.dao;

import com.fyc.dao.model.User;

public interface UserDAO {

    /**
     * Поиск пользователя по username
     *
     * @param username username
     * @return модель пользователя с деталями
     */
    User findByUsername(String username);

    /**
     * Поиск пользователя по email
     *
     * @param email email
     * @return
     */
    User findByEmail(String email);

}
