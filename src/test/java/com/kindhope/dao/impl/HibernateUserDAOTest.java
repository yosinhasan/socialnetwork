package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
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
        userDAO.create(user);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml"));
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
        String email = "email@email.com";
        User expected = new User();
        expected.setEmail(email);
        userDAO.create(expected);
        User actual = userDAO.findByEmail(email);
        assertEquals(expected, actual);
    }

    @Test
    public void create() throws Exception {
        User user2 = new User();
        user2.setEmail("test2@mail.com");
        user2.setName("test");
        assertNotNull(userDAO.create(user2));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(userDAO.read(User.class, BigInteger.ONE));
    }

    @Test
    public void update() throws Exception {
        String email = "test@test.com";
        user.setEmail(email);
        userDAO.update(user);
        assertNotNull(userDAO.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        User test = new User();
        String email = "test@test.fy";
        test.setEmail(email);
        userDAO.create(test);
        assertNotNull(userDAO.findByEmail(email));
        userDAO.delete(test);
        assertNull(userDAO.findByEmail(email));
    }

    private User getUser() {
        User test = new User();
        test.setName("Yosin");
        test.setEmail("yosinhasan@gmail.com");
        test.setPassword("123456");
        return test;
    }

}