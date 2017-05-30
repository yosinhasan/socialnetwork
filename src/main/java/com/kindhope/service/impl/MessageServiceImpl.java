package com.kindhope.service.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.Message;
import com.kindhope.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAO messageDAO;

    @Override
    public Message read(BigInteger id) {
        return messageDAO.read(Message.class, id);
    }

    @Override
    public BigInteger create(Message object) {
        return messageDAO.create(object);
    }

    @Override
    public void update(Message object) {
        messageDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        messageDAO.delete(object);
    }

    @Override
    public List<Message> readAll() {
        return messageDAO.readAll();
    }

    @Override
    public boolean addSeenAtTimestamp(BigInteger conversationId, BigInteger userId) {
        return messageDAO.addSeenAtTimestamp(conversationId, userId);
    }

    @Override
    public Message findLastMessage(BigInteger conversationId) {
        return messageDAO.findLastMessage(conversationId);
    }

    @Override
    public List<Message> findConversationMessages(BigInteger conversationId) {
        return messageDAO.findConversationMessages(conversationId);
    }
}
