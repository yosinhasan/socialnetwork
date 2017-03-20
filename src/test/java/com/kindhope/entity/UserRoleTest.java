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
public class UserRoleTest {
    private UserRole testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new UserRole();
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
        UserRole object = new UserRole();
        assertTrue(testObject.equals(object));
    }

    @Test
    public void testRoleByRoleId() throws Exception {
        Role expected = new Role();
        testObject.setRoleByRoleId(expected);
        assertEquals(expected, testObject.getRoleByRoleId());
    }

    @Test
    public void testUserByUserId() throws Exception {
        User expected = new User();
        testObject.setUserByUserId(expected);
        assertEquals(expected, testObject.getUserByUserId());
    }

}