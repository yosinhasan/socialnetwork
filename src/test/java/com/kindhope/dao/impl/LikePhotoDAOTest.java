package com.kindhope.dao.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
import com.kindhope.entity.LikePhotoPK;
import com.kindhope.entity.LikePhoto;
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
public class LikePhotoDAOTest extends AbstractDAOImplTest {

    @Autowired
    LikePhotoDAO dao;

    LikePhoto object;

    LikePhotoPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/LikePhoto.xml"));
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
        assertNotNull(dao.read(LikePhoto.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(LikePhoto.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        LikePhoto test = dao.read(LikePhoto.class, pk);
        test.setPhotoId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        LikePhoto test = dao.read(LikePhoto.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        LikePhotoPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(LikePhoto.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        LikePhoto test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private LikePhoto getNewInstance(long id1, long id2) {
        LikePhoto test = new LikePhoto();
        test.setUserId(BigInteger.valueOf(id1));
        test.setPhotoId(BigInteger.valueOf(id2));
        return test;
    }

    private LikePhotoPK getNewPKInstance(long id1, long id2) {
        LikePhotoPK pk = new LikePhotoPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setPhotoId(BigInteger.valueOf(id2));
        return pk;
    }

}