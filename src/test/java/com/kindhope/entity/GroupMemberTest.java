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
public class GroupMemberTest {
    private GroupMember testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GroupMember();
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
    public void testUserId() throws Exception {
        testObject.setUserId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getUserId());
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
    public void testBlockedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        testObject.setBlockedAt(expected);
        assertEquals(expected, testObject.getBlockedAt());
    }


    @Test
    public void equals() throws Exception {
        GroupMember groupMember = new GroupMember();
        assertTrue(testObject.equals(groupMember));
    }

    @Test
    public void testGroupByGroupId() throws Exception {
        Group expected = new Group();
        testObject.setGroupByGroupId(expected);
        assertEquals(expected, testObject.getGroupByGroupId());
    }

    @Test
    public void testUserByUserId() throws Exception {
        User expected = new User();
        testObject.setUserByUserId(expected);
        assertEquals(expected, testObject.getUserByUserId());
    }

}