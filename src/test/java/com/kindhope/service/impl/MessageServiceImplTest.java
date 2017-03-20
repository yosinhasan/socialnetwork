package com.kindhope.service.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.Message;
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
public class MessageServiceImplTest {
    @Mock
    MessageDAO dao;
    @InjectMocks
    MessageServiceImpl service;

    @Spy
    List<Message> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Message expected = list.get(0);
        when(dao.read(Message.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Message object = new Message();
        object.setUserId(expected);
        when(dao.create(any(Message.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Message.class));
        service.update(any(Message.class));
        verify(dao, atLeastOnce()).update(any(Message.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Message.class));
        service.delete(any(Message.class));
        verify(dao, atLeastOnce()).delete(any(Message.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Message object = new Message();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}