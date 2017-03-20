package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ConnectionPKTest {
    private ConnectionPK testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new ConnectionPK();
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
        ConnectionPK connection = new ConnectionPK();
        assertTrue(testObject.equals(connection));
    }

}