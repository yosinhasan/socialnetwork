package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import com.kindhope.entity.User;
import com.kindhope.web.exception.DAOException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.NonUniqueObjectException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ConnectionRequestDAOTest extends AbstractDAOImplTest {

    @Autowired
    ConnectionRequestDAO dao;

    ConnectionRequest object;

    ConnectionRequestPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/ConnectionRequest.xml"));
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
        assertNotNull(dao.read(ConnectionRequest.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(ConnectionRequest.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        ConnectionRequest test = dao.read(ConnectionRequest.class, pk);
        test.setUserId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        ConnectionRequest test = dao.read(ConnectionRequest.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        ConnectionRequestPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(ConnectionRequest.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        ConnectionRequest test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void findReceivedRequests() {
        List<User> users = dao.findReceivedRequests(BigInteger.valueOf(6));
        assertNotNull(users);
        assertEquals(2, users.size());
        dao.removeRequest(BigInteger.valueOf(4), BigInteger.valueOf(6));
        users = dao.findReceivedRequests(BigInteger.valueOf(6));
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void findSentRequests() {
        List<User> users = dao.findSentRequests(BigInteger.valueOf(3));
        assertNotNull(users);
        assertEquals(1, users.size());
        dao.removeRequest(BigInteger.valueOf(3), BigInteger.valueOf(5));
        users = dao.findSentRequests(BigInteger.valueOf(3));
        assertNotNull(users);
        assertEquals(0, users.size());

    }

    @Test
    public void removeRequest() {
        dao.removeRequest(BigInteger.valueOf(4), BigInteger.valueOf(6));
    }

    @Test(expected = DAOException.class)
    public void removeRequestShouldFail() {
        dao.removeRequest(BigInteger.ONE, BigInteger.valueOf(-1));
    }

    @Test
    public void restoreRequest() {
        dao.restoreRequest(BigInteger.valueOf(4), BigInteger.valueOf(6));
    }

    @Test(expected = DAOException.class)
    public void restoreRequestShouldFail() {
        dao.restoreRequest(BigInteger.ONE, BigInteger.valueOf(-1));
    }

    @Test
    public void countRequests() {
        long size = dao.countRequests(BigInteger.valueOf(6));
        assertEquals(2, size);
    }

    private ConnectionRequest getNewInstance(long id1, long id2) {
        ConnectionRequest test = new ConnectionRequest();
        test.setUserId(BigInteger.valueOf(id1));
        test.setRequestId(BigInteger.valueOf(id2));
        return test;
    }

    private ConnectionRequestPK getNewPKInstance(long id1, long id2) {
        ConnectionRequestPK pk = new ConnectionRequestPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setRequestId(BigInteger.valueOf(id2));
        return pk;
    }

}