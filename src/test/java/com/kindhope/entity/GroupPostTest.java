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
public class GroupPostTest {
    private GroupPost testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GroupPost();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testGroupId() throws Exception {
        testObject.setGroupId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getGroupId());
    }

    @Test
    public void testPostId() throws Exception {
        testObject.setPostId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getPostId());
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
        GroupPost object = new GroupPost();
        assertTrue(testObject.equals(object));
    }

    @Test
    public void testPostByPostId() throws Exception {
        Post expected = new Post();
        testObject.setPostByPostId(expected);
        assertEquals(expected, testObject.getPostByPostId());
    }

    @Test
    public void testGroupByGroupId() throws Exception {
        Group expected = new Group();
        testObject.setGroupByGroupId(expected);
        assertEquals(expected, testObject.getGroupByGroupId());
    }

}