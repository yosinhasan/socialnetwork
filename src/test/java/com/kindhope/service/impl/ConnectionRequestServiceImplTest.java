package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
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
public class ConnectionRequestServiceImplTest {
    @Mock
    ConnectionRequestDAO dao;
    @InjectMocks
    ConnectionRequestServiceImpl service;

    @Spy
    List<ConnectionRequest> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        ConnectionRequest expected = list.get(0);
        when(dao.read(ConnectionRequest.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        ConnectionRequest object = new ConnectionRequest();
        object.setUserId(expected);
        when(dao.create(any(ConnectionRequest.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(ConnectionRequest.class));
        service.update(any(ConnectionRequest.class));
        verify(dao, atLeastOnce()).update(any(ConnectionRequest.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(ConnectionRequest.class));
        service.delete(any(ConnectionRequest.class));
        verify(dao, atLeastOnce()).delete(any(ConnectionRequest.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        ConnectionRequest object = new ConnectionRequest();
        object.setUserId(BigInteger.ONE);
        object.setRequestId(BigInteger.TEN);
        list.add(object);
    }
}