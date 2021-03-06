package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
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
public class ConnectionServiceImplTest {
    @Mock
    ConnectionDAO dao;
    @InjectMocks
    ConnectionServiceImpl service;

    @Spy
    List<Connection> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Connection expected = list.get(0);
        when(dao.read(Connection.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Connection object = new Connection();
        object.setUserId(expected);
        when(dao.create(any(Connection.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Connection.class));
        service.update(any(Connection.class));
        verify(dao, atLeastOnce()).update(any(Connection.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Connection.class));
        service.delete(any(Connection.class));
        verify(dao, atLeastOnce()).delete(any(Connection.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Connection object = new Connection();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }
}