package com.kindhope.service.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.CommentPhoto;
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
public class CommentPhotoServiceImplTest {
    @Mock
    CommentPhotoDAO dao;
    @InjectMocks
    CommentPhotoServiceImpl service;

    @Spy
    List<CommentPhoto> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initList();

    }

    @Test
    public void read() throws Exception {
        CommentPhoto expected = list.get(0);
        when(dao.read(CommentPhoto.class, expected.getPhotoId())).thenReturn(expected);
        assertEquals(expected, service.read(expected.getPhotoId()));
    }

    @Test
    public void create() throws Exception {
        BigInteger expected = BigInteger.valueOf(3L);
        CommentPhoto object = new CommentPhoto();
        object.setPhotoId(expected);
        when(dao.create(any(CommentPhoto.class))).thenReturn(expected);
        assertEquals(expected, service.create(object));
    }

    @Test
    public void update() throws Exception {
        doNothing().when(dao).update(any(CommentPhoto.class));
        service.update(any(CommentPhoto.class));
        verify(dao, atLeastOnce()).update(any(CommentPhoto.class));
    }

    @Test
    public void delete() throws Exception {
        doNothing().when(dao).delete(any(CommentPhoto.class));
        service.delete(any(CommentPhoto.class));
        verify(dao, atLeastOnce()).delete(any(CommentPhoto.class));
    }

    @Test
    public void readAll() throws Exception {
        when(dao.readAll()).thenReturn(list);
        assertEquals(list, dao.readAll());
    }

    public void initList() {
        CommentPhoto object = new CommentPhoto();
        object.setPhotoId(BigInteger.ONE);
        list.add(object);
    }
}