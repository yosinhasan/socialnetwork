package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class UserServiceImplTest {

    @Mock
    UserDAO userDAO;
    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    UserServiceImpl userService;

    @Spy
    List<User> userList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initUserList();

    }

    @Test
    public void read() throws Exception {
        User expected = userList.get(0);
        when(userDAO.read(User.class, expected.getId())).thenReturn(expected);
        assertEquals(expected, userService.read(expected.getId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        User newUser = new User();
        newUser.setId(expected);
        newUser.setName("Test3");
        newUser.setPassword("123456");
        when(userDAO.create(any(User.class))).thenReturn(expected);
        assertEquals(expected, userService.create(newUser));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(userDAO).update(any(User.class));
        userService.update(any(User.class));
        verify(userDAO, atLeastOnce()).update(any(User.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(userDAO).delete(any(User.class));
        userService.delete(any(User.class));
        verify(userDAO, atLeastOnce()).delete(any(User.class));
    }

    @Test
    public void readAll() throws Exception {
        when(userDAO.readAll()).thenReturn(userList);
        assertEquals(userList, userDAO.readAll());
    }

    @Test
    public void findByEmail() throws Exception {
        User expected = userList.get(0);
        when(userDAO.findByEmail(expected.getEmail())).thenReturn(expected);
        assertEquals(expected, userDAO.findByEmail(expected.getEmail()));
    }

    public void initUserList() {
        User user1 = new User();
        user1.setId(BigInteger.ONE);
        user1.setName("Test1");
        user1.setEmail("test1@test.com");
        user1.setPassword("123456");

        User user2 = new User();
        user1.setId(BigInteger.ONE);
        user1.setName("Test2");
        user1.setEmail("test2@test.com");
        user1.setPassword("123456");

        userList.add(user1);
        userList.add(user2);
    }
}