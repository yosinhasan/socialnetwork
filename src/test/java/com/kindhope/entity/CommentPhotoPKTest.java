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
public class CommentPhotoPKTest {
    private CommentPhotoPK commentPhoto;

    @Before
    public void setUp() throws Exception {
        commentPhoto = new CommentPhotoPK();
    }

    @After
    public void tearDown() throws Exception {
        commentPhoto = null;
    }

    @Test
    public void testCommentId() throws Exception {
        commentPhoto.setCommentId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, commentPhoto.getCommentId());
    }

    @Test
    public void testPhotoId() throws Exception {
        commentPhoto.setPhotoId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, commentPhoto.getPhotoId());
    }

    @Test
    public void equals() throws Exception {
        CommentPhotoPK test = new CommentPhotoPK();
        assertTrue(commentPhoto.equals(test));
    }

}