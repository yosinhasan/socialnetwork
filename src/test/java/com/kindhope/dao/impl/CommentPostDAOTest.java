package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.CommentPost;
import com.kindhope.entity.CommentPostPK;
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
public class CommentPostDAOTest extends AbstractDAOImplTest {

    @Autowired
    CommentPostDAO dao;

    CommentPost object;

    CommentPostPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 1);
        pk = getNewPKInstance(1, 1);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/CommentPost.xml"));
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
        assertNotNull(dao.read(CommentPost.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(CommentPost.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        CommentPost test = dao.read(CommentPost.class, pk);
        test.setPostId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        CommentPost test = dao.read(CommentPost.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        CommentPostPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(CommentPost.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        CommentPost test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private CommentPost getNewInstance(long id1, long id2) {
        CommentPost test = new CommentPost();
        test.setCommentId(BigInteger.valueOf(id1));
        test.setPostId(BigInteger.valueOf(id2));
        return test;
    }

    private CommentPostPK getNewPKInstance(long id1, long id2) {
        CommentPostPK pk = new CommentPostPK();
        pk.setCommentId(BigInteger.valueOf(id1));
        pk.setPostId(BigInteger.valueOf(id2));
        return pk;
    }

}