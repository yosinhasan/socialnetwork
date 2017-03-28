package com.kindhope.dao.impl;

import com.kindhope.dao.UserRoleDAO;
import com.kindhope.entity.UserRole;
import com.kindhope.entity.UserRolePK;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.NonUniqueObjectException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class UserRoleDAOTest extends AbstractDAOImplTest {

    @Autowired
    UserRoleDAO dao;

    UserRole object;

    UserRolePK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/UserRole.xml"));
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

    @Test
    public void save() throws Exception {
        assertNotNull(dao.save(object));
    }

    @Test(expected = NonUniqueObjectException.class)
    public void saveDuplicate() throws Exception {
        dao.save(getNewInstance(10, 12));
        dao.save(getNewInstance(10, 12));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(UserRole.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(UserRole.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        UserRole test = dao.read(UserRole.class, pk);
        test.setUserId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        UserRole test = dao.read(UserRole.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        UserRolePK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(UserRole.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        UserRole test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private UserRole getNewInstance(long id1, int id2) {
        UserRole test = new UserRole();
        test.setUserId(BigInteger.valueOf(id1));
        test.setRoleId(id2);
        return test;
    }

    private UserRolePK getNewPKInstance(long id1, int id2) {
        UserRolePK pk = new UserRolePK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setRoleId(id2);
        return pk;
    }
}