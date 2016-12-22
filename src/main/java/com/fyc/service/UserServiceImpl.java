package com.fyc.service;

import com.fyc.controller.model.UserDTO;
import com.fyc.dao.GenericDAO;
import com.fyc.dao.UserDAO;
import com.fyc.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    @Qualifier(value = "genericDAOImpl")
    private GenericDAO<User, String> genericDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        User user;
        try {
            user = userDAO.findByUsername(username);
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user;
        try {
            user = userDAO.findByEmail(email);
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    @Override
    public boolean isUsernameBusy(String username) {
        User user = this.findByUsername(username);
        return user != null;
    }

    @Override
    public boolean isEmailBusy(String username) {
        User user = this.findByEmail(username);
        return user != null;
    }

    @Transactional
    @Override
    public User create(UserDTO userDTO) {

        String username = userDTO.getUsername();
        String email = userDTO.getEmail();
        String password = passwordEncoder.encode(userDTO.getPassword());

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean accountNonLocked = true;
        boolean credentialsNonExpired = true;

        User user = new User(username, email, password, null, null, enabled, accountNonExpired,
                accountNonLocked, credentialsNonExpired);

        return genericDAO.create(user);
    }

    @Override
    public User update(User user) {
        return genericDAO.update(user);
    }
}
