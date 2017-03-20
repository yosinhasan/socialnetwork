package com.kindhope.service.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
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
public class BlacklistServiceImplTest {

    @Mock
    BlacklistDAO dao;
    @InjectMocks
    BlacklistServiceImpl service;

    @Spy
    List<Blacklist> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Blacklist expected = list.get(0);
        when(dao.read(Blacklist.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Blacklist object = new Blacklist();
        object.setUserId(expected);
        when(dao.create(any(Blacklist.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Blacklist.class));
        service.update(any(Blacklist.class));
        verify(dao, atLeastOnce()).update(any(Blacklist.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Blacklist.class));
        service.delete(any(Blacklist.class));
        verify(dao, atLeastOnce()).delete(any(Blacklist.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Blacklist object = new Blacklist();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}