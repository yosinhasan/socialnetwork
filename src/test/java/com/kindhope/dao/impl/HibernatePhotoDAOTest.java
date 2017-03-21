package com.kindhope.dao.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.Photo;
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
public class HibernatePhotoDAOTest extends AbstractDAOImplTest {

    @Autowired
    PhotoDAO dao;

    Photo object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Photo.xml"));
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
        assertNotNull(dao.read(Photo.class, BigInteger.ONE));
    }

    @Test
    public void update() throws Exception {
//        String email = "updated@test.com";
//        Photo test = dao.findByEmail("test@tset.dom");
//        test.setEmail(email);
//        dao.update(test);
//        assertNotNull(dao.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test2@tset.dom";
//        Photo test = dao.findByEmail(email);
//        assertNotNull(test);
//        dao.delete(test);
//        assertNull(dao.findByEmail(email));
    }

    private Photo getObject() {
        Photo test = new Photo();
//        test.setName("Test object");
//        test.setEmail("testPhoto@gmail.com");
//        test.setPassword("123456");
        return test;
    }

}