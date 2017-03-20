package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GalleryPhotoPKTest {
    private GalleryPhotoPK testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GalleryPhotoPK();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testGalleryId() throws Exception {
        testObject.setGalleryId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getGalleryId());
    }

    @Test
    public void testPhotoId() throws Exception {
        testObject.setPhotoId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getPhotoId());
    }

    @Test
    public void equals() throws Exception {
        GalleryPhotoPK photoPK = new GalleryPhotoPK();
        assertTrue(testObject.equals(photoPK));
    }

}