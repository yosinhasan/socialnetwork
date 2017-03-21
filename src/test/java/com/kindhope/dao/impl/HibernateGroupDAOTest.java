package com.kindhope.dao.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.Group;
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
public class HibernateGroupDAOTest extends AbstractDAOImplTest {

    @Autowired
    GroupDAO dao;

    Group object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Group.xml"));
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
        assertNotNull(dao.read(Group.class, BigInteger.ONE));
    }

    @Test
    public void update() throws Exception {
        String email = "updated@test.com";
//        Group test = dao.findByEmail("test@tset.dom");
//        test.setEmail(email);
//        dao.update(test);
//        assertNotNull(dao.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test2@tset.dom";
//        Group test = dao.findByEmail(email);
//        assertNotNull(test);
//        dao.delete(test);
//        assertNull(dao.findByEmail(email));
    }

    private Group getObject() {
        Group test = new Group();
//        test.setName("Test object");
//        test.setEmail("testGroup@gmail.com");
//        test.setPassword("123456");
        return test;
    }

}