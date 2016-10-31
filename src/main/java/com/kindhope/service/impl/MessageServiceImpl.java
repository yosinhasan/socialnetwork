package com.kindhope.service.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.MessagesEntity;
import com.kindhope.service.MessageService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class MessageServiceImpl implements MessageService {
    private MessageDAO messageDAO;

    public MessageServiceImpl(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public MessagesEntity read(BigInteger id) {
        return messageDAO.read(MessagesEntity.class, id);
    }

    @Override
    public Boolean create(MessagesEntity object) {
        return messageDAO.create(object);
    }

    @Override
    public Boolean update(MessagesEntity object) {
        return messageDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return messageDAO.delete(object);
    }

    @Override
    public List<MessagesEntity> readAll() {
        return messageDAO.readAll();
    }
}
