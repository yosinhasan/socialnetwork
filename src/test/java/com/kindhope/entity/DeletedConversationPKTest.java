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
public class DeletedConversationPKTest {

    private DeletedConversationPK DeletedConversationPK;

    @Before
    public void setUp() throws Exception {
        DeletedConversationPK = new DeletedConversationPK();
    }

    @After
    public void tearDown() throws Exception {
        DeletedConversationPK = null;
    }

    @Test
    public void testUserId() throws Exception {
        DeletedConversationPK.setUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, DeletedConversationPK.getUserId());
    }

    @Test
    public void testConversationId() throws Exception {
        DeletedConversationPK.setConversationId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, DeletedConversationPK.getConversationId());
    }

    @Test
    public void equals() throws Exception {
        DeletedConversationPK testDeletedConversationPK = new DeletedConversationPK();
        testDeletedConversationPK.setUserId(BigInteger.ONE);
        assertFalse(DeletedConversationPK.equals(testDeletedConversationPK));
    }

}