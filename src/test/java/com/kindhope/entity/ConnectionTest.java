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
public class ConnectionTest {
    private Connection testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Connection();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testUserId() throws Exception {
        testObject.setUserId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getUserId());
    }

    @Test
    public void testFriendId() throws Exception {
        testObject.setFriendId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, testObject.getFriendId());
    }

    @Test
    public void equals() throws Exception {
        Connection connection = new Connection();
        assertTrue(testObject.equals(connection));
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
    public void testUserByUserId() throws Exception {
        User expected = new User();
        testObject.setUserByUserId(expected);
        assertEquals(expected, testObject.getUserByUserId());
    }

    @Test
    public void testUserByFriendId() throws Exception {
        User expected = new User();
        testObject.setUserByFriendId(expected);
        assertEquals(expected, testObject.getUserByFriendId());
    }

}