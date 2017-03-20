package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GalleryPhotoTest {
    private GalleryPhoto testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GalleryPhoto();
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
    public void testCreatedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        testObject.setCreatedAt(expected);
        assertEquals(expected, testObject.getCreatedAt());
    }

    @Test
    public void testUpdatedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        testObject.setUpdatedAt(expected);
        assertEquals(expected, testObject.getUpdatedAt());
    }

    @Test
    public void testDeletedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        testObject.setDeletedAt(expected);
        assertEquals(expected, testObject.getDeletedAt());
    }

    @Test
    public void equals() throws Exception {
        GalleryPhoto galleryPhoto = new GalleryPhoto();
        assertTrue(testObject.equals(galleryPhoto));
    }

    @Test
    public void testPhotoByPhotoId() throws Exception {
        Photo expected = new Photo();
        testObject.setPhotoByPhotoId(expected);
        assertEquals(expected, testObject.getPhotoByPhotoId());
    }

    @Test
    public void testGalleryByGalleryId() throws Exception {
        Gallery expected = new Gallery();
        testObject.setGalleryByGalleryId(expected);
        assertEquals(expected, testObject.getGalleryByGalleryId());
    }

}