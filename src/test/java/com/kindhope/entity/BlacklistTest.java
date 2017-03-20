package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class BlacklistTest {
    private Blacklist blacklist;

    @Before
    public void setUp() throws Exception {
        blacklist = new Blacklist();
    }

    @After
    public void tearDown() throws Exception {
        blacklist = null;
    }

    @Test
    public void testUserId() throws Exception {
        blacklist.setUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, blacklist.getUserId());
    }

    @Test
    public void testBlockedUserId() throws Exception {
        blacklist.setBlockedUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, blacklist.getBlockedUserId());
    }

    @Test
    public void testCreatedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        blacklist.setCreatedAt(expected);
        assertEquals(expected, blacklist.getCreatedAt());
    }

    @Test
    public void equals() throws Exception {
        Blacklist testBlacklist = new Blacklist();
        testBlacklist.setUserId(BigInteger.ONE);
        assertFalse(blacklist.equals(testBlacklist));
    }

    @Test
    public void testUserByUserId() throws Exception {
        User expected = new User();
        blacklist.setUserByUserId(expected);
        assertEquals(expected, blacklist.getUserByUserId());
    }

    @Test
    public void testUserByBlockedUserId() throws Exception {
        User expected = new User();
        blacklist.setUserByBlockedUserId(expected);
        assertEquals(expected, blacklist.getUserByBlockedUserId());
    }

}