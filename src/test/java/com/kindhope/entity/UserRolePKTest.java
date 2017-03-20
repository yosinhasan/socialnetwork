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
public class UserRolePKTest {
    private UserRolePK testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new UserRolePK();
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
    public void testRoleId() throws Exception {
        testObject.setRoleId(1);
        assertEquals(Integer.valueOf(1), testObject.getRoleId());
    }

    @Test
    public void equals() throws Exception {
        UserRolePK object = new UserRolePK();
        assertTrue(testObject.equals(object));
    }

}