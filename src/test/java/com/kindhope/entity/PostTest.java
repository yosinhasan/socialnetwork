package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class PostTest {
    private Post testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Post();
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
    public void testPost() throws Exception {
        String expected = "post";
        testObject.setPost(expected);
        assertEquals(expected, testObject.getPost());
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
        Post object = new Post();
        assertTrue(testObject.equals(object));
    }

    @Test
    public void testGroupPostsById() throws Exception {
        ArrayList<GroupPost> list = new ArrayList<>();
        testObject.setGroupPostsById(list);
        assertEquals(list, testObject.getGroupPostsById());
    }

}