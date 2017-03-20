package com.kindhope.service.impl;

import com.kindhope.service.SecurityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class SecurityServiceImpl implements SecurityService {
    private static final Logger LOG = Logger.getLogger(SecurityServiceImpl.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInUserEmail() {
        LOG.debug("FIND LOGGED IN USER EMAIL START");
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        LOG.trace("FOUND USER DETAILS: " + userDetails);
        if (userDetails instanceof UserDetails) {
            LOG.trace("USER LOGGED IN :)");
            LOG.debug("FIND LOGGED IN USER EMAIL END");
            return ((UserDetails) userDetails).getUsername();
        }
        LOG.trace("USER NOT LOGGED IN (:");
        LOG.debug("FIND LOGGED IN USER EMAIL END");
        return null;
    }

    @Override
    public void autologin(String email, String password) {
        LOG.debug("FIND AUTO LOGIN START");
        LOG.trace("PARAM email: " + email);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        LOG.trace("USER DETAILS: " + userDetails.getUsername() + ", " + userDetails.getAuthorities());
        LOG.trace("PASSWORD: " + password);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        LOG.trace("AUTHENTICATE START");
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LOG.trace("AUTHENTICATE END");
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            LOG.debug(String.format("AUTO LOGIN %s successfully!", email));
        }
        LOG.debug("FIND AUTO LOGIN END");
    }
}
