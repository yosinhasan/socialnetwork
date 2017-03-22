package com.kindhope.dao.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.Message;
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
public class PhotoDAOTest extends AbstractDAOImplTest {

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
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Photo.class, BigInteger.valueOf(999)));
    }
    @Test
    public void update() throws Exception {
        String expected = "updated";
        Photo test = dao.read(Photo.class, BigInteger.valueOf(2));
        assertNotNull(test);
        test.setName(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Photo.class, BigInteger.valueOf(2)).getName());
    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Photo test = dao.read(Photo.class, BigInteger.valueOf(1));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Photo getObject() {
        Photo test = new Photo();
        test.setName("Test object");
        test.setUserId(BigInteger.ONE);
        return test;
    }

}