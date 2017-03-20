package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import com.kindhope.entity.UserRole;
import com.kindhope.helper.Constants;
import org.apache.log4j.Logger;
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

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger LOG = Logger.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LOG.debug("LOAD USER BY EMAIL START:  PARAM EMAIL = " + email);
        if (userDAO == null) {
            LOG.trace("USER DAO IS NULL");
        }
        User user = userDAO.findByEmail(email);
        LOG.trace("FOUND USER: " + user);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        LOG.trace("USER'S PERMISSION: " + user.getUserRolesById());
        grantedAuthorities.add(new SimpleGrantedAuthority(Constants.ROLE_USER));
        for (UserRole role : user.getUserRolesById()) {
            LOG.trace("USER PERMISSION: " + role.getRoleByRoleId().getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleByRoleId().getName()));

        }
        //java 8
//        user.getUserRolesById().stream().forEach(s -> {
//            LOG.trace("USER PERMISSION: " + s.getRoleByRoleId().getName());
//            grantedAuthorities.add(new SimpleGrantedAuthority(s.getRoleByRoleId().getName()));
//        });
        LOG.debug("LOAD USER BY EMAIL END");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
