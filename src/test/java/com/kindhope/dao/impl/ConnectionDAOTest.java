package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
import com.kindhope.entity.Connection;
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
public class ConnectionDAOTest extends AbstractDAOImplTest {

    @Autowired
    ConnectionDAO dao;

    Connection object;

    ConnectionPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Connection.xml"));
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
        assertNotNull(dao.read(Connection.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(Connection.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        Connection test = dao.read(Connection.class, pk);
        test.setUserId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        Connection test = dao.read(Connection.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        ConnectionPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(Connection.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        Connection test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Connection getNewInstance(long id1, long id2) {
        Connection test = new Connection();
        test.setUserId(BigInteger.valueOf(id1));
        test.setFriendId(BigInteger.valueOf(id2));
        return test;
    }

    private ConnectionPK getNewPKInstance(long id1, long id2) {
        ConnectionPK pk = new ConnectionPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setFriendId(BigInteger.valueOf(id2));
        return pk;
    }

}