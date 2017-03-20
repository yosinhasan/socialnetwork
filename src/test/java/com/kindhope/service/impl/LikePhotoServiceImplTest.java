package com.kindhope.service.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
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
public class LikePhotoServiceImplTest {
    @Mock
    LikePhotoDAO dao;
    @InjectMocks
    LikePhotoServiceImpl service;

    @Spy
    List<LikePhoto> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        LikePhoto expected = list.get(0);
        when(dao.read(LikePhoto.class, expected.getUserId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getUserId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        LikePhoto object = new LikePhoto();
        object.setUserId(expected);
        when(dao.create(any(LikePhoto.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(LikePhoto.class));
        service.update(any(LikePhoto.class));
        verify(dao, atLeastOnce()).update(any(LikePhoto.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(LikePhoto.class));
        service.delete(any(LikePhoto.class));
        verify(dao, atLeastOnce()).delete(any(LikePhoto.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        LikePhoto object = new LikePhoto();
        object.setUserId(BigInteger.ONE);
        list.add(object);
    }

}