package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;
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
public class CommentPhotoDAOTest extends AbstractDAOImplTest {

    @Autowired
    CommentPhotoDAO dao;

    CommentPhoto object;

    CommentPhotoPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 6);
        pk = getNewPKInstance(1, 6);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/CommentPhoto.xml"));
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
        assertNotNull(dao.read(CommentPhoto.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(CommentPhoto.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        CommentPhoto test = dao.read(CommentPhoto.class, pk);
        test.setPhotoId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        CommentPhoto test = dao.read(CommentPhoto.class, getNewPKInstance(6, 6));
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        CommentPhotoPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(CommentPhoto.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        CommentPhoto test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void findComments() {
        List<Comment> comments = dao.findComments(BigInteger.valueOf(6));
        assertNotNull(comments);
        assertEquals(3, comments.size());
    }

    private CommentPhoto getNewInstance(long id1, long id2) {
        CommentPhoto test = new CommentPhoto();
        test.setCommentId(BigInteger.valueOf(id1));
        test.setPhotoId(BigInteger.valueOf(id2));
        return test;
    }

    private CommentPhotoPK getNewPKInstance(long id1, long id2) {
        CommentPhotoPK pk = new CommentPhotoPK();
        pk.setCommentId(BigInteger.valueOf(id1));
        pk.setPhotoId(BigInteger.valueOf(id2));
        return pk;
    }

}