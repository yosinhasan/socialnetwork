package com.kindhope.dao.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.entity.GroupPost;
import com.kindhope.entity.GroupPostPK;
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
public class GroupPostDAOTest extends AbstractDAOImplTest {

    @Autowired
    GroupPostDAO dao;

    GroupPost object;

    GroupPostPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/GroupPost.xml"));
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
        assertNotNull(dao.read(GroupPost.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(GroupPost.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        GroupPost test = dao.read(GroupPost.class, pk);
        test.setPostId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        GroupPost test = dao.read(GroupPost.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        GroupPostPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(GroupPost.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        GroupPost test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private GroupPost getNewInstance(long id1, long id2) {
        GroupPost test = new GroupPost();
        test.setGroupId(BigInteger.valueOf(id1));
        test.setPostId(BigInteger.valueOf(id2));
        return test;
    }

    private GroupPostPK getNewPKInstance(long id1, long id2) {
        GroupPostPK pk = new GroupPostPK();
        pk.setGroupId(BigInteger.valueOf(id1));
        pk.setPostId(BigInteger.valueOf(id2));
        return pk;
    }

}