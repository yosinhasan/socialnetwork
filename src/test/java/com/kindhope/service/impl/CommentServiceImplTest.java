package com.kindhope.service.impl;

import com.kindhope.dao.CommentDAO;
import com.kindhope.entity.Comment;
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
public class CommentServiceImplTest {
    @Mock
    CommentDAO dao;
    @InjectMocks
    CommentServiceImpl service;

    @Spy
    List<Comment> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Comment expected = list.get(0);
        when(dao.read(Comment.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Comment object = new Comment();
        object.setUserId(expected);
        when(dao.create(any(Comment.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Comment.class));
        service.update(any(Comment.class));
        verify(dao, atLeastOnce()).update(any(Comment.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Comment.class));
        service.delete(any(Comment.class));
        verify(dao, atLeastOnce()).delete(any(Comment.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Comment object = new Comment();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }
}