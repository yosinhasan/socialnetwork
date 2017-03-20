package com.kindhope.service.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.entity.GroupPost;
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
public class GroupPostServiceImplTest {
    @Mock
    GroupPostDAO dao;
    @InjectMocks
    GroupPostServiceImpl service;

    @Spy
    List<GroupPost> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        GroupPost expected = list.get(0);
        when(dao.read(GroupPost.class, expected.getPostId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getPostId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        GroupPost object = new GroupPost();
        object.setPostId(expected);
        when(dao.create(any(GroupPost.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(GroupPost.class));
        service.update(any(GroupPost.class));
        verify(dao, atLeastOnce()).update(any(GroupPost.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(GroupPost.class));
        service.delete(any(GroupPost.class));
        verify(dao, atLeastOnce()).delete(any(GroupPost.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        GroupPost object = new GroupPost();
        object.setPostId(BigInteger.ONE);
        list.add(object);
    }

}