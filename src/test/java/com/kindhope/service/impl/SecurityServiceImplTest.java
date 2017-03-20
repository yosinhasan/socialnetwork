package com.kindhope.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class SecurityServiceImplTest {
    @Mock
    AuthenticationManager manager;

    @Mock
    UserDetailsService userDetailsService;

    @InjectMocks
    SecurityServiceImpl service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findLoggedInUserEmail() {
        //to do
    }

    @Test
    public void autologin(String email, String password) {
        //to do
    }

}