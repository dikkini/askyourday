package com.askyourday.service;

import com.askyourday.dao.UserDAO;
import com.askyourday.dao.model.Privilege;
import com.askyourday.dao.model.Role;
import com.askyourday.dao.model.User;
import com.askyourday.exception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service("userDetailsService")
public class YetUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginAttemptService loginAttemptService;

    public YetUserDetailsServiceImpl() {
        super();
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        boolean blocked = loginAttemptService.isBlocked(email);
        if (blocked) {
            throw new UserBlockedException("user_blocked_message", 1000);
        }

        final User user = userDAO.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            for (final Privilege privilege : role.getPrivileges()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), grantedAuthorities);
    }
}
