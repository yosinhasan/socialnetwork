package com.kindhope.service.impl;

import com.kindhope.dao.UserRoleDAO;
import com.kindhope.entity.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

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
public class UserRoleServiceImplTest {
    @Mock
    UserRoleDAO dao;
    @InjectMocks
    UserRoleServiceImpl service;

    @Spy
    List<UserRole> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        UserRole expected = list.get(0);
        when(dao.read(UserRole.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        UserRole object = new UserRole();
        object.setUserId(expected);
        when(dao.create(any(UserRole.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(UserRole.class));
        service.update(any(UserRole.class));
        verify(dao, atLeastOnce()).update(any(UserRole.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(UserRole.class));
        service.delete(any(UserRole.class));
        verify(dao, atLeastOnce()).delete(any(UserRole.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        UserRole object = new UserRole();
        object.setRoleId(anyInt());
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}