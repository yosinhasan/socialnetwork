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
public class CommentPostPKTest {
    private CommentPostPK testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new CommentPostPK();
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void testCommentId() throws Exception {
        testObject.setCommentId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getCommentId());
    }

    @Test
    public void testPostId() throws Exception {
        testObject.setPostId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getPostId());
    }

    @Test
    public void equals() throws Exception {
        CommentPostPK object = new CommentPostPK();
        assertTrue(testObject.equals(object));
    }
}