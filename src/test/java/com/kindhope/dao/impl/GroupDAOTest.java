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
public class GroupDAOTest extends AbstractDAOImplTest {

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
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Group.class, BigInteger.valueOf(999)));
    }
    @Test
    public void update() throws Exception {
        String expected = "updated";
        Group test = dao.read(Group.class, BigInteger.valueOf(2));
        assertNotNull(test);
        test.setTitle(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Group.class, BigInteger.valueOf(2)).getTitle());

    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Group test = dao.read(Group.class, BigInteger.valueOf(1));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Group getObject() {
        Group test = new Group();
        test.setTitle("test title");
        test.setUserId(BigInteger.ONE);
        test.setDescription("description");
        return test;
    }

}