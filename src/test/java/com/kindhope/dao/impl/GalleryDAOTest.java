package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
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
public class GalleryDAOTest extends AbstractDAOImplTest {

    @Autowired
    GalleryDAO dao;

    Gallery object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Gallery.xml"));
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
        assertNotNull(dao.read(Gallery.class, BigInteger.valueOf(6)));
    }

    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Gallery.class, BigInteger.valueOf(999)));
    }

    @Test
    public void update() throws Exception {
        String expected = "updated";
        Gallery test = dao.read(Gallery.class, BigInteger.valueOf(8));
        assertNotNull(test);
        test.setName(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Gallery.class, BigInteger.valueOf(8)).getName());
    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Gallery test = dao.read(Gallery.class, BigInteger.valueOf(8));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Gallery getObject() {
        Gallery test = new Gallery();
        test.setName("Test object");
        test.setUserId(BigInteger.valueOf(9));
        return test;
    }

}