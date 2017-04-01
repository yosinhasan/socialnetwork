package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class DeletedConversationTest {
    private DeletedConversation deletedConversation;

    @Before
    public void setUp() throws Exception {
        deletedConversation = new DeletedConversation();
    }

    @After
    public void tearDown() throws Exception {
        deletedConversation = null;
    }

    @Test
    public void testUserId() throws Exception {
        deletedConversation.setUserId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, deletedConversation.getUserId());
    }

    @Test
    public void testConversationId() throws Exception {
        deletedConversation.setConversationId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, deletedConversation.getConversationId());
    }

    @Test
    public void testDeletedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        deletedConversation.setDeletedAt(expected);
        assertEquals(expected, deletedConversation.getDeletedAt());
    }

    @Test
    public void equals() throws Exception {
        DeletedConversation testDeletedConversation = new DeletedConversation();
        testDeletedConversation.setUserId(BigInteger.ONE);
        assertFalse(deletedConversation.equals(testDeletedConversation));
    }

    @Test
    public void testUserByUserId() throws Exception {
        Conversation expected = new Conversation();
        deletedConversation.setConversationByConversationId(expected);
        assertEquals(expected, deletedConversation.getConversationByConversationId());

    }


}