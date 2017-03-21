package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class HibernateBlacklistDAOTest extends AbstractDAOImplTest {

    @Autowired
    BlacklistDAO dao;

    Blacklist object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
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

    @Test
    public void read() throws Exception {
        BlacklistPK pk = new BlacklistPK();
        pk.setBlockedUserId(BigInteger.valueOf(2));
        pk.setUserId(BigInteger.valueOf(1));
        assertNotNull(dao.read(pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(Blacklist.class, BigInteger.ONE);
        assertFalse(true);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        BlacklistPK pk = new BlacklistPK();
        pk.setBlockedUserId(BigInteger.valueOf(2));
        pk.setUserId(BigInteger.valueOf(1));
        Blacklist test = dao.read(pk);
        assertNotNull(test);
        pk.setBlockedUserId(BigInteger.TEN);
        test.setBlockedUserId(BigInteger.TEN);
        dao.update(test);
        assertNotNull(dao.read(pk));
        assertFalse(true);
    }

    @Test
    public void delete() throws Exception {
        BlacklistPK pk = new BlacklistPK();
        pk.setBlockedUserId(BigInteger.valueOf(2));
        pk.setUserId(BigInteger.valueOf(1));
        Blacklist test = dao.read(pk);
        assertNotNull(test);
        dao.delete(test);
        assertNotNull(dao.read(pk));
    }
    @Test(expected = EntityNotFoundException.class)
    public void deleteThrowsNotFoundException() throws Exception {
        BlacklistPK pk = new BlacklistPK();
        pk.setBlockedUserId(BigInteger.valueOf(111));
        pk.setUserId(BigInteger.valueOf(1));
        Blacklist test = dao.read(pk);
        assertNotNull(test);
        dao.delete(test);
        assertNotNull(dao.read(pk));
        assertFalse(true);
    }

    private Blacklist getObject() {
        Blacklist test = new Blacklist();
        test.setUserId(BigInteger.ONE);
        test.setBlockedUserId(BigInteger.TEN);
        return test;
    }

}