package com.askyourday.service;

import com.askyourday.controller.model.UserDTO;
import com.askyourday.dao.RoleDAO;
import com.askyourday.dao.UserDAO;
import com.askyourday.dao.model.Role;
import com.askyourday.dao.model.User;
import com.askyourday.exception.EmailExistException;
import com.askyourday.exception.UsernameExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationContext context;

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
    public User registerUser(UserDTO userDTO) throws UsernameExistException, EmailExistException {

        String username = userDTO.getUsername();
        boolean usernameBusy = isUsernameBusy(username);
        if (usernameBusy) {
            throw new UsernameExistException(context.getMessage("UsernameExistException", null, LocaleContextHolder.getLocale()));
        }

        String email = userDTO.getEmail();
        boolean emailBusy = isEmailBusy(email);
        if (emailBusy) {
            throw new EmailExistException(context.getMessage("EmailExistException", null, LocaleContextHolder.getLocale()));
        }

        String password = passwordEncoder.encode(userDTO.getPassword());

        Collection<Role> roles = new ArrayList<>();
        Role userRole = roleDAO.findUserRole();
        roles.add(userRole);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean accountNonLocked = true;
        boolean credentialsNonExpired = true;

        User user = new User(username, email, password, null, null, enabled, accountNonExpired,
                accountNonLocked, credentialsNonExpired, roles, 0);

        return userDAO.create(user);
    }

    @Transactional
    @Override
    public User registerSocialUser(String username, String firstName, String lastName, String email, int authProvider) {
        Collection<Role> roles = new ArrayList<>();
        Role userRole = roleDAO.findUserRole();
        roles.add(userRole);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean accountNonLocked = true;
        boolean credentialsNonExpired = true;

        User user = new User(username, email, null, firstName, lastName, enabled, accountNonExpired,
                accountNonLocked, credentialsNonExpired, roles, authProvider);

        return userDAO.create(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }
}
