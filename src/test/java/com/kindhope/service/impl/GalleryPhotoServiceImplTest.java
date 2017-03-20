package com.kindhope.service.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
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
public class GalleryPhotoServiceImplTest {
    @Mock
    GalleryPhotoDAO dao;
    @InjectMocks
    GalleryPhotoServiceImpl service;

    @Spy
    List<GalleryPhoto> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        GalleryPhoto expected = list.get(0);
        when(dao.read(GalleryPhoto.class, expected.getPhotoId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getPhotoId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        GalleryPhoto object = new GalleryPhoto();
        object.setPhotoId(expected);
        when(dao.create(any(GalleryPhoto.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(GalleryPhoto.class));
        service.update(any(GalleryPhoto.class));
        verify(dao, atLeastOnce()).update(any(GalleryPhoto.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(GalleryPhoto.class));
        service.delete(any(GalleryPhoto.class));
        verify(dao, atLeastOnce()).delete(any(GalleryPhoto.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        GalleryPhoto object = new GalleryPhoto();
        object.setPhotoId(BigInteger.ONE);
        list.add(object);
    }

}