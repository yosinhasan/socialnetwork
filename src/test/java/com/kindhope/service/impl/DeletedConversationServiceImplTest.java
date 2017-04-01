package com.kindhope.service.impl;

import com.kindhope.dao.DeletedConversationDAO;
import com.kindhope.entity.DeletedConversation;
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
public class DeletedConversationServiceImplTest {
    @Mock
    DeletedConversationDAO dao;
    @InjectMocks
    DeletedConversationServiceImpl service;

    @Spy
    List<DeletedConversation> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        DeletedConversation expected = list.get(0);
        when(dao.read(DeletedConversation.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        DeletedConversation object = new DeletedConversation();
        object.setUserId(expected);
        when(dao.create(any(DeletedConversation.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(DeletedConversation.class));
        service.update(any(DeletedConversation.class));
        verify(dao, atLeastOnce()).update(any(DeletedConversation.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(DeletedConversation.class));
        service.delete(any(DeletedConversation.class));
        verify(dao, atLeastOnce()).delete(any(DeletedConversation.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        DeletedConversation object = new DeletedConversation();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}