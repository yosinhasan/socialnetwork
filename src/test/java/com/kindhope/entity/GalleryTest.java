package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GalleryTest {
    private Gallery testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Gallery();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testId() throws Exception {
        testObject.setId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getId());
    }


    @Test
    public void testName() throws Exception {
        String expected = "test";
        testObject.setName(expected);
        assertEquals(expected, testObject.getName());
    }

    @Test
    public void testUserId() throws Exception {
        testObject.setUserId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getUserId());
    }

    @Test
    public void equals() throws Exception {
        Gallery gallery = new Gallery();
        assertTrue(testObject.equals(gallery));
    }

    @Test
    public void testUserByUserId() throws Exception {
        User expected = new User();
        testObject.setUserByUserId(expected);
        assertEquals(expected, testObject.getUserByUserId());
    }

    @Test
    public void testGalleryPhotosById() throws Exception {
        ArrayList<GalleryPhoto> expected = new ArrayList<>();
        testObject.setGalleryPhotosById(expected);
        assertEquals(expected, testObject.getGalleryPhotosById());
    }

}