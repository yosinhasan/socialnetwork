package com.kindhope.dao.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.Message;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MessageDAOTest extends AbstractDAOImplTest {

    @Autowired
    MessageDAO dao;

    Message object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/Message.xml"));
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
        assertNotNull(dao.read(Message.class, BigInteger.ONE));
    }

    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(Message.class, BigInteger.valueOf(999)));
    }

    @Test
    public void update() throws Exception {
        String expected = "updated";
        Message test = dao.read(Message.class, BigInteger.valueOf(2));
        assertNotNull(test);
        test.setContent(expected);
        dao.update(test);
        assertEquals(expected, dao.read(Message.class, BigInteger.valueOf(2)).getContent());

    }

    @Test
    public void delete() throws Exception {
        int expected = dao.readAll().size() - 1;
        Message test = dao.read(Message.class, BigInteger.valueOf(1));
        assertNotNull(test);
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void findConversationMessages() {
        List<Message> test = dao.findConversationMessages(BigInteger.valueOf(1));
        assertNotNull(test);
        assertEquals(4, test.size());
    }

    @Test
    public void findLastMessage() {
        Message message = dao.findLastMessage(BigInteger.ONE);
        assertNotNull(message);
        assertEquals(BigInteger.valueOf(6), message.getId());
        assertEquals(BigInteger.valueOf(1), message.getUserId());
        assertEquals(BigInteger.valueOf(1), message.getConversationId());
        assertEquals("content4", message.getContent());

    }

    @Test
    public void addSeenAtTimestamp() {
        boolean actual = dao.addSeenAtTimestamp(BigInteger.ONE, BigInteger.ONE);
        assertEquals(true, actual);
        List<Message> list = dao.findConversationMessages(BigInteger.ONE);
    }

    private Message getObject() {
        Message test = new Message();
        test.setContent("content test");
        test.setUserId(BigInteger.ONE);
        test.setConversationId(BigInteger.valueOf(2));
        return test;
    }

}