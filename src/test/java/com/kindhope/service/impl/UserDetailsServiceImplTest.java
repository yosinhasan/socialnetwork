package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class UserDetailsServiceImplTest {

    @Mock
    UserDAO dao;

    @InjectMocks
    UserDetailsServiceImpl service;

    @Spy
    User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initUser();
    }

    private void initUser() {
        user = new User();
        user.setId(BigInteger.ONE);
        user.setEmail("test@test.com");
        user.setUserRolesById(new ArrayList<>());
    }

    @Test
    public void loadUserByUsername() {
//        when(dao.findByEmail(user.getEmail())).thenReturn(user);
//        assertNotNull(service.loadUserByUsername(user.getEmail()));
        // to do
    }

}