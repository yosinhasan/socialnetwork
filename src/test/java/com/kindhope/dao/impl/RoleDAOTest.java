package com.kindhope.dao.impl;

import com.kindhope.dao.RoleDAO;
import com.kindhope.entity.Role;
import com.kindhope.entity.Role;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class RoleDAOTest extends AbstractDAOImplTest {
    @Autowired
    RoleDAO dao;
    
    Role object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Role.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test(expected = RuntimeException.class)
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test(expected = RuntimeException.class)
    public void read() throws Exception {
        assertNotNull(dao.read(Role.class, BigInteger.ONE));
    }

    @Test
    public void readIntId() throws Exception {
        assertNotNull(dao.read(1));
    }
    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(999));
    }

    @Test
    public void update() throws Exception {
        String expected = "updated";
        Role test = dao.read(2);
        assertNotNull(test);
        test.setName(expected);
        dao.update(test);
        assertEquals(expected, dao.read(2).getName());

    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Role test = dao.read(1);
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Role getObject() {
        Role test = new Role();
        test.setName("ROLE_TEST");
        return test;
    }
}