package com.kindhope.service.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.entity.Post;
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
public class PostServiceImplTest {
    @Mock
    PostDAO dao;
    @InjectMocks
    PostServiceImpl service;

    @Spy
    List<Post> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Post expected = list.get(0);
        when(dao.read(Post.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Post object = new Post();
        object.setUserId(expected);
        when(dao.create(any(Post.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Post.class));
        service.update(any(Post.class));
        verify(dao, atLeastOnce()).update(any(Post.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Post.class));
        service.delete(any(Post.class));
        verify(dao, atLeastOnce()).delete(any(Post.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Post object = new Post();
        object.setUserId(BigInteger.ONE);
        object.setId(BigInteger.ONE);
        list.add(object);
    }

}