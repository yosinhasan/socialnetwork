package com.kindhope.dao.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.entity.Photo;
import com.kindhope.entity.Post;
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
public class PostDAOTest extends AbstractDAOImplTest {

    @Autowired
    PostDAO dao;

    Post object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Post.xml"));
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
        assertNotNull(dao.read(Post.class, BigInteger.ONE));
    }
    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Post.class, BigInteger.valueOf(999)));
    }
    @Test
    public void update() throws Exception {
        String expected = "updated";
        Post test = dao.read(Post.class, BigInteger.valueOf(2));
        assertNotNull(test);
        test.setPost(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Post.class, BigInteger.valueOf(2)).getPost());

    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Post test = dao.read(Post.class, BigInteger.valueOf(1));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private Post getObject() {
        Post test = new Post();
        test.setPost("Test object");
        test.setUserId(BigInteger.ONE);
        return test;
    }

}