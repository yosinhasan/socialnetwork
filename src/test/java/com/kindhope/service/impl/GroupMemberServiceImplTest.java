package com.kindhope.service.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.entity.GroupMember;
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
public class GroupMemberServiceImplTest {
    @Mock
    GroupMemberDAO dao;
    @InjectMocks
    GroupMemberServiceImpl service;

    @Spy
    List<GroupMember> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        GroupMember expected = list.get(0);
        when(dao.read(GroupMember.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        GroupMember object = new GroupMember();
        object.setUserId(expected);
        when(dao.create(any(GroupMember.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(GroupMember.class));
        service.update(any(GroupMember.class));
        verify(dao, atLeastOnce()).update(any(GroupMember.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(GroupMember.class));
        service.delete(any(GroupMember.class));
        verify(dao, atLeastOnce()).delete(any(GroupMember.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        GroupMember object = new GroupMember();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}