package com.kindhope.service.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.Photo;
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
public class PhotoServiceImplTest {
    @Mock
    PhotoDAO dao;
    @InjectMocks
    PhotoServiceImpl service;

    @Spy
    List<Photo> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Photo expected = list.get(0);
        when(dao.read(Photo.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Photo object = new Photo();
        object.setUserId(expected);
        when(dao.create(any(Photo.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Photo.class));
        service.update(any(Photo.class));
        verify(dao, atLeastOnce()).update(any(Photo.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Photo.class));
        service.delete(any(Photo.class));
        verify(dao, atLeastOnce()).delete(any(Photo.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Photo object = new Photo();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}