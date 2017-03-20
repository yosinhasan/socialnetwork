package com.kindhope.service.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
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
public class GalleryServiceImplTest {
    @Mock
    GalleryDAO dao;
    @InjectMocks
    GalleryServiceImpl service;

    @Spy
    List<Gallery> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        Gallery expected = list.get(0);
        when(dao.read(Gallery.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        Gallery object = new Gallery();
        object.setUserId(expected);
        when(dao.create(any(Gallery.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(Gallery.class));
        service.update(any(Gallery.class));
        verify(dao, atLeastOnce()).update(any(Gallery.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(Gallery.class));
        service.delete(any(Gallery.class));
        verify(dao, atLeastOnce()).delete(any(Gallery.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        Gallery object = new Gallery();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}