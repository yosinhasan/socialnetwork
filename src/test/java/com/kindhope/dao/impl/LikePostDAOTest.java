package com.kindhope.dao.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePost;
import com.kindhope.entity.LikePostPK;
import com.kindhope.entity.LikePost;
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
public class LikePostDAOTest extends AbstractDAOImplTest {

    @Autowired
    LikePostDAO dao;

    LikePost object;

    LikePostPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/LikePost.xml"));
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
        assertNotNull(dao.read(LikePost.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(LikePost.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        LikePost test = dao.read(LikePost.class, pk);
        test.setUserId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        LikePost test = dao.read(LikePost.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        LikePostPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(LikePost.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        LikePost test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private LikePost getNewInstance(long id1, long id2) {
        LikePost test = new LikePost();
        test.setUserId(BigInteger.valueOf(id1));
        test.setPostId(BigInteger.valueOf(id2));
        return test;
    }

    private LikePostPK getNewPKInstance(long id1, long id2) {
        LikePostPK pk = new LikePostPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setPostId(BigInteger.valueOf(id2));
        return pk;
    }

}