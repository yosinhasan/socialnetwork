package com.kindhope.service.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.CommentPost;
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
public class CommentPostServiceImplTest {
    @Mock
    CommentPostDAO dao;
    @InjectMocks
    CommentPostServiceImpl service;

    @Spy
    List<CommentPost> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        CommentPost expected = list.get(0);
        when(dao.read(CommentPost.class, expected.getPostId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getPostId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        CommentPost object = new CommentPost();
        object.setPostId(expected);
        when(dao.create(any(CommentPost.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(CommentPost.class));
        service.update(any(CommentPost.class));
        verify(dao, atLeastOnce()).update(any(CommentPost.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(CommentPost.class));
        service.delete(any(CommentPost.class));
        verify(dao, atLeastOnce()).delete(any(CommentPost.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        CommentPost object = new CommentPost();
        object.setPostId(BigInteger.ONE);
        list.add(object);
    }
}