package com.kindhope.service.impl;

import com.kindhope.dao.ConversationDAO;
import com.kindhope.entity.Conversation;
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
public class ConversationServiceImplTest {
    @Mock
    ConversationDAO dao;
    @InjectMocks
    ConversationServiceImpl service;

    @Spy
    List<Conversation> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Conversation expected = list.get(0);
        when(dao.read(Conversation.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Conversation object = new Conversation();
        object.setUserId(expected);
        when(dao.create(any(Conversation.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Conversation.class));
        service.update(any(Conversation.class));
        verify(dao, atLeastOnce()).update(any(Conversation.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Conversation.class));
        service.delete(any(Conversation.class));
        verify(dao, atLeastOnce()).delete(any(Conversation.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Conversation object = new Conversation();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}