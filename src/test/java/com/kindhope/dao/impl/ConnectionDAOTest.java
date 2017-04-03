package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
import com.kindhope.entity.User;
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
        dao.removeConnection(BigInteger.valueOf(6), BigInteger.valueOf(5));
        dao.removeConnection(BigInteger.valueOf(6), BigInteger.valueOf(4));
        dao.removeConnection(BigInteger.valueOf(3), BigInteger.valueOf(5));

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

    @Test
    public void findConnections() {
        List<User> users = dao.findConnections(BigInteger.ONE);
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void findFollowers() {
        List<User> users = dao.findFollowers(BigInteger.ONE);
        assertNotNull(users);
        assertEquals(0, users.size());
        users = dao.findFollowers(BigInteger.valueOf(6));
        assertNotNull(users);
        assertEquals(2, users.size());
    }


    @Test
    public void countFollowers() {
        Long actual = dao.countFollowers(BigInteger.valueOf(6));
        assertEquals(Long.valueOf(2), actual);
        actual = dao.countFollowers(BigInteger.valueOf(1));
        assertEquals(Long.valueOf(0), actual);
    }

    @Test
    public void findFollowing() {
        List<User> users = dao.findFollowing(BigInteger.ONE);
        assertNotNull(users);
        assertEquals(0, users.size());
        users = dao.findFollowing(BigInteger.valueOf(5));
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void countFollowing() {
        Long actual = dao.countFollowings(BigInteger.valueOf(6));
        assertEquals(Long.valueOf(0), actual);
        actual = dao.countFollowings(BigInteger.valueOf(5));
        assertEquals(Long.valueOf(2), actual);
    }

    @Test
    public void countConnections() {
        Long actual = dao.countConnections(BigInteger.ONE);
        assertEquals(Long.valueOf(2), actual);
        actual = dao.countConnections(BigInteger.valueOf(6));
        assertEquals(Long.valueOf(0), actual);
    }
    @Test
    public void removeConnection() {
        Connection test = dao.read(Connection.class, ConnectionPK.valueOf(BigInteger.valueOf(6), BigInteger.valueOf(5)));
        assertNotNull(test);
        assertNotNull(test.getDeletedAt());
        test = dao.read(Connection.class, ConnectionPK.valueOf(BigInteger.valueOf(6), BigInteger.valueOf(4)));
        assertNotNull(test);
        assertNotNull(test.getDeletedAt());
    }
    @Test
    public void restoreConnection() {
        dao.restoreConnection(BigInteger.valueOf(6), BigInteger.valueOf(5));
        Connection test = dao.read(Connection.class, ConnectionPK.valueOf(BigInteger.valueOf(6), BigInteger.valueOf(5)));
        assertNotNull(test);
        assertNull(test.getDeletedAt());
        assertNotNull(test.getUpdatedAt());
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