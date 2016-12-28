package com.fyc.service;


import com.fyc.controller.model.UserDTO;
import com.fyc.dao.model.User;
import com.fyc.exception.EmailExistException;
import com.fyc.exception.UsernameExistException;

public interface UserService {

    /**
     *
     * @param userDTO
     * @return
     */
    User registerUser(final UserDTO userDTO) throws UsernameExistException, EmailExistException;

    /**
     *
     * @param user
     * @return
     */
    User update(final User user);

    /**
     *
     * @param username
     * @return
     */
    User findByUsername(String username);


    /**
     *
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     *
     * @param username
     * @return
     */
    boolean isUsernameBusy(String username);

    /**
     *
     * @param username
     * @return
     */
    boolean isEmailBusy(String username);
}
