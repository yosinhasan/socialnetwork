package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import com.kindhope.entity.GalleryPhoto;
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
public class GalleryPhotoDAOTest extends AbstractDAOImplTest {

    @Autowired
    GalleryPhotoDAO dao;

    GalleryPhoto object;

    GalleryPhotoPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/GalleryPhoto.xml"));
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
        assertNotNull(dao.read(GalleryPhoto.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(GalleryPhoto.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        GalleryPhoto test = dao.read(GalleryPhoto.class, pk);
        test.setPhotoId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        GalleryPhoto test = dao.read(GalleryPhoto.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        GalleryPhotoPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(GalleryPhoto.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        GalleryPhoto test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private GalleryPhoto getNewInstance(long id1, long id2) {
        GalleryPhoto test = new GalleryPhoto();
        test.setGalleryId(BigInteger.valueOf(id1));
        test.setPhotoId(BigInteger.valueOf(id2));
        return test;
    }

    private GalleryPhotoPK getNewPKInstance(long id1, long id2) {
        GalleryPhotoPK pk = new GalleryPhotoPK();
        pk.setGalleryId(BigInteger.valueOf(id1));
        pk.setPhotoId(BigInteger.valueOf(id2));
        return pk;
    }

}