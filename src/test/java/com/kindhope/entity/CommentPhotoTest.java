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
public class CommentPhotoTest {
    private CommentPhoto testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new CommentPhoto();
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
    public void testPhotoId() throws Exception {
        testObject.setPhotoId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, testObject.getPhotoId());
    }

    @Test
    public void equals() throws Exception {
        CommentPhoto test = new CommentPhoto();
        assertTrue(testObject.equals(test));
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


}