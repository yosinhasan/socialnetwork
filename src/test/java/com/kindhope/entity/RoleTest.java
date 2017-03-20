package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class RoleTest {
    private Role testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Role();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testId() throws Exception {
        testObject.setId(1);
        assertEquals(Integer.valueOf(1), testObject.getId());
    }

    @Test
    public void testName() throws Exception {
        String expected = "test";
        testObject.setName(expected);
        assertEquals(expected, testObject.getName());
    }

    @Test
    public void equals() throws Exception {
        Role object = new Role();
        assertTrue(testObject.equals(object));
    }

    @Test
    public void testUserRolesById() throws Exception {
        ArrayList<UserRole> list = new ArrayList<>();
        testObject.setUserRolesById(list);
        assertEquals(list, testObject.getUserRolesById());
    }

}