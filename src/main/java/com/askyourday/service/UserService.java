package com.askyourday.service;


import com.askyourday.controller.model.UserDTO;
import com.askyourday.dao.model.User;
import com.askyourday.exception.EmailExistException;
import com.askyourday.exception.UsernameExistException;

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
