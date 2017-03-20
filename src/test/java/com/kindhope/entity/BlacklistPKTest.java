package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class BlacklistPKTest {

    private BlacklistPK blacklistPK;

    @Before
    public void setUp() throws Exception {
        blacklistPK = new BlacklistPK();
    }

    @After
    public void tearDown() throws Exception {
        blacklistPK = null;
    }

    @Test
    public void testUserId() throws Exception {
        blacklistPK.setUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, blacklistPK.getUserId());
    }

    @Test
    public void testBlockedUserId() throws Exception {
        blacklistPK.setBlockedUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, blacklistPK.getBlockedUserId());
    }

    @Test
    public void equals() throws Exception {
        BlacklistPK testBlacklistPK = new BlacklistPK();
        testBlacklistPK.setUserId(BigInteger.ONE);
        assertFalse(blacklistPK.equals(testBlacklistPK));
    }

}