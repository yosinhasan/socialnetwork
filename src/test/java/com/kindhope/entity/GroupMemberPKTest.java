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
public class GroupMemberPKTest {
    private GroupMemberPK testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GroupMemberPK();
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
    public void equals() throws Exception {
        GroupMemberPK groupMemberPK = new GroupMemberPK();
        assertTrue(testObject.equals(groupMemberPK));
    }

}