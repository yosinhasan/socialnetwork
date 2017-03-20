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
public class PhotoTest {
    private Photo testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Photo();
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
    public void testUserId() throws Exception {
        testObject.setUserId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getUserId());
    }

    @Test
    public void testName() throws Exception {
        String expected = "test";
        testObject.setName(expected);
        assertEquals(expected, testObject.getName());
    }

    @Test
    public void equals() throws Exception {
        Photo object = new Photo();
        assertTrue(testObject.equals(object));
    }

    @Test
    public void testGalleryPhotosById() throws Exception {
        ArrayList<GalleryPhoto> galleryPhotos = new ArrayList<>();
        testObject.setGalleryPhotosById(galleryPhotos);
        assertEquals(galleryPhotos, testObject.getGalleryPhotosById());
    }

    @Test
    public void testUserByUserId() throws Exception {
        User expected = new User();
        testObject.setUserByUserId(expected);
        assertEquals(expected, testObject.getUserByUserId());
    }

    @Test
    public void testUsersById() throws Exception {
        ArrayList<User> userArrayList = new ArrayList<>();
        testObject.setUsersById(userArrayList);
        assertEquals(userArrayList, testObject.getUsersById());
    }

}