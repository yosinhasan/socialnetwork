package com.kindhope.service.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.Group;
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
public class GroupServiceImplTest {
    @Mock
    GroupDAO dao;
    @InjectMocks
    GroupServiceImpl service;

    @Spy
    List<Group> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Group expected = list.get(0);
        when(dao.read(Group.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Group object = new Group();
        object.setUserId(expected);
        when(dao.create(any(Group.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Group.class));
        service.update(any(Group.class));
        verify(dao, atLeastOnce()).update(any(Group.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Group.class));
        service.delete(any(Group.class));
        verify(dao, atLeastOnce()).delete(any(Group.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Group object = new Group();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}