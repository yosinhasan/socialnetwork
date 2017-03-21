package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
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

public class HibernateUserDAOTest extends AbstractDAOImplTest {

    @Autowired
    UserDAO userDAO;

    User user;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        user = getUser();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/User.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(userDAO.readAll());
    }

    @Test
    public void findByEmailReturnsNull() throws Exception {
        assertNull(userDAO.findByEmail("something@gmail.com"));
    }

    @Test
    public void findByEmail() throws Exception {
        assertNotNull(userDAO.findByEmail("test@tset.dom"));
    }

    @Test
    public void create() throws Exception {
        assertNotNull(userDAO.create(user));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(userDAO.read(User.class, BigInteger.ONE));
    }

    @Test
    public void update() throws Exception {
        String email = "updated@test.com";
        User test = userDAO.findByEmail("test@tset.dom");
        test.setEmail(email);
        userDAO.update(test);
        assertNotNull(userDAO.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test2@tset.dom";
        User test = userDAO.findByEmail(email);
        assertNotNull(test);
        userDAO.delete(test);
        assertNull(userDAO.findByEmail(email));
    }

    private User getUser() {
        User test = new User();
        test.setName("Test user");
        test.setEmail("testuser@gmail.com");
        test.setPassword("123456");
        return test;
    }

}