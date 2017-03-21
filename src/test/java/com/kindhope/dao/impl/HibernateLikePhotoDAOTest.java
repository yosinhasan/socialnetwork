package com.kindhope.dao.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class HibernateLikePhotoDAOTest extends AbstractDAOImplTest {

    @Autowired
    LikePhotoDAO dao;

    LikePhoto object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/LikePhoto.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(LikePhoto.class, BigInteger.ONE));
    }

    @Test
    public void update() throws Exception {
        String email = "updated@test.com";
//        LikePhoto test = dao.findByEmail("test@tset.dom");
//        test.setEmail(email);
//        dao.update(test);
//        assertNotNull(dao.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test2@tset.dom";
//        LikePhoto test = dao.findByEmail(email);
//        assertNotNull(test);
//        dao.delete(test);
//        assertNull(dao.findByEmail(email));
    }

    private LikePhoto getObject() {
        LikePhoto test = new LikePhoto();
//        test.setName("Test object");
//        test.setEmail("testLikePhoto@gmail.com");
//        test.setPassword("123456");
        return test;
    }

}