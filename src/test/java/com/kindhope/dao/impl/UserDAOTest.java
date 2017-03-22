package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.User;
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

public class UserDAOTest extends AbstractDAOImplTest {

    @Autowired
    UserDAO dao;

    User object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/User.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test
    public void findByEmailReturnsNull() throws Exception {
        assertNull(dao.findByEmail("something@gmail.com"));
    }

    @Test
    public void findByEmail() throws Exception {
        assertNotNull(dao.findByEmail("test@tset.dom"));
    }

    @Test
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(User.class, BigInteger.ONE));
    }
    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(User.class, BigInteger.valueOf(999)));
    }
    @Test
    public void update() throws Exception {
        String email = "updated@test.com";
        User test = dao.findByEmail("test@tset.dom");
        test.setEmail(email);
        dao.update(test);
        assertNotNull(dao.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test2@tset.dom";
        User test = dao.findByEmail(email);
        assertNotNull(test);
        dao.delete(test);
        assertNull(dao.findByEmail(email));
    }

    private User getObject() {
        User test = new User();
        test.setName("Test object");
        test.setEmail("testuser@gmail.com");
        test.setPassword("123456");
        return test;
    }

}