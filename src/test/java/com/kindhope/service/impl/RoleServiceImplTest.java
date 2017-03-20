package com.kindhope.service.impl;

import com.kindhope.dao.RoleDAO;
import com.kindhope.entity.Role;
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
public class RoleServiceImplTest {
    @Mock
    RoleDAO dao;
    @InjectMocks
    RoleServiceImpl service;

    @Spy
    List<Role> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test(expected = RuntimeException.class)
    public void readAndThrowException() throws Exception {
        Role expected = list.get(0);
        when(dao.read(Role.class, BigInteger.ONE)).thenThrow(RuntimeException.class);
        assertEquals(expected, service.read(BigInteger.ONE));
    }

    @Test
    public void read() throws Exception {
        Role expected = list.get(0);
        when(dao.read(anyInt())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getId()));
    }

    @Test(expected = RuntimeException.class)
    public void create() throws Exception {
        Integer expected = 2;
        Role object = new Role();
        object.setId(expected);
        when(dao.create(any(Role.class))).thenThrow(RuntimeException.class);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void save() throws Exception {
        Integer expected = 2;
        Role object = new Role();
        object.setId(expected);
        when(dao.createAndReturnIntId(any(Role.class))).thenReturn(expected);
        assertEquals(expected, service.save(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Role.class));
        service.update(any(Role.class));
        verify(dao, atLeastOnce()).update(any(Role.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Role.class));
        service.delete(any(Role.class));
        verify(dao, atLeastOnce()).delete(any(Role.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Role object = new Role();
        object.setId(anyInt());
        list.add(object);
    }

}