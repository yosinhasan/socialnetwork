package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class BlacklistDAOTest extends AbstractDAOImplTest {

    @Autowired
    BlacklistDAO dao;

    Blacklist object;

    BlacklistPK pk;


    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 10);
        pk = getNewPKInstance(1, 2);

    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Blacklist.xml"));
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
        dao.save(getNewInstance(1, 10));
        dao.save(getNewInstance(1, 10));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(Blacklist.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(Blacklist.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        Blacklist test = dao.read(Blacklist.class, pk);
        test.setBlockedUserId(BigInteger.TEN);
        dao.update(test);
    }
    @Test
    public void delete() throws Exception {
        Blacklist test = dao.read(Blacklist.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        BlacklistPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(Blacklist.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        Blacklist test = getNewInstance(1, 111);
        int expected =  dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }
    private Blacklist getNewInstance(long id1, long id2) {
        Blacklist test = new Blacklist();
        test.setUserId(BigInteger.valueOf(id1));
        test.setBlockedUserId(BigInteger.valueOf(id2));
        return test;
    }

    private BlacklistPK getNewPKInstance(long id1, long id2) {
        BlacklistPK pk = new BlacklistPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setBlockedUserId(BigInteger.valueOf(id2));
        return pk;
    }
}