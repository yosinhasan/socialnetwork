package com.kindhope.dao.impl;

import com.kindhope.dao.ConversationDAO;
import com.kindhope.entity.Conversation;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ConversationDAOTest extends AbstractDAOImplTest {

    @Autowired
    ConversationDAO dao;

    Conversation object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Conversation.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(Conversation.class, BigInteger.ONE));
    }

    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Conversation.class, BigInteger.valueOf(999)));
    }

    @Test
    public void update() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        Conversation test = dao.read(Conversation.class, BigInteger.valueOf(2));
        assertNotNull(test);
        test.setCreatedAt(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Conversation.class, BigInteger.valueOf(2)).getCreatedAt());

    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Conversation test = dao.read(Conversation.class, BigInteger.valueOf(1));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void findUserConversations() throws Exception {
        List<Conversation> test = dao.findUserConversations(BigInteger.valueOf(1));
        assertNotNull(test);
        assertEquals(1, test.size());
    }

    @Test
    public void findUserConversationIds() throws Exception {
        List<BigInteger> test = dao.findUserConversationIds(BigInteger.valueOf(3));
        assertNotNull(test);
        assertEquals(3, test.size());
    }
    @Test
    public void findWithMessages() {
        Conversation conversation = dao.findWithMessages(BigInteger.valueOf(1));
        assertNotNull(conversation);
        assertEquals(6, conversation.getMessages().size());
    }
    private Conversation getObject() {
        Conversation test = new Conversation();
        test.setUserId(BigInteger.ONE);
        test.setFriendId(BigInteger.valueOf(4));
        return test;
    }

}