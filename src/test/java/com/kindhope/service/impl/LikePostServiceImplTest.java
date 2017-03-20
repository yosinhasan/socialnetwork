package com.kindhope.service.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePost;
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
public class LikePostServiceImplTest {
    @Mock
    LikePostDAO dao;
    @InjectMocks
    LikePostServiceImpl service;

    @Spy
    List<LikePost> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        LikePost expected = list.get(0);
        when(dao.read(LikePost.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        LikePost object = new LikePost();
        object.setUserId(expected);
        when(dao.create(any(LikePost.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(LikePost.class));
        service.update(any(LikePost.class));
        verify(dao, atLeastOnce()).update(any(LikePost.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(LikePost.class));
        service.delete(any(LikePost.class));
        verify(dao, atLeastOnce()).delete(any(LikePost.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        LikePost object = new LikePost();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}