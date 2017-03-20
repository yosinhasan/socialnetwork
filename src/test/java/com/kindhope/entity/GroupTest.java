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
public class GroupTest {
    private Group testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Group();
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
    public void testTitle() throws Exception {
        String expected = "test";
        testObject.setTitle(expected);
        assertEquals(expected, testObject.getTitle());
    }

    @Test
    public void testDescription() throws Exception {
        String expected = "test";
        testObject.setDescription(expected);
        assertEquals(expected, testObject.getDescription());
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
        Group object = new Group();
        assertTrue(testObject.equals(object));

    }

    @Test
    public void testGroupMembersById() throws Exception {
        ArrayList<GroupMember> expected = new ArrayList<>();
        testObject.setGroupMembersById(expected);
        assertEquals(expected, testObject.getGroupMembersById());
    }

    @Test
    public void testGroupPostsById() throws Exception {
        ArrayList<GroupPost> expected = new ArrayList<>();
        testObject.setGroupPostsById(expected);
        assertEquals(expected, testObject.getGroupPostsById());
    }

}