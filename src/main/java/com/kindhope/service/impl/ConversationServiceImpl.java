package com.kindhope.service.impl;

import com.kindhope.dao.ConversationDAO;
import com.kindhope.entity.Conversation;
import com.kindhope.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    private ConversationDAO ConversationDAO;

    @Override
    public Conversation read(BigInteger id) {
        return ConversationDAO.read(Conversation.class, id);
    }

    @Override
    public BigInteger create(Conversation object) {
        return ConversationDAO.create(object);
    }

    @Override
    public void update(Conversation object) {
        ConversationDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        ConversationDAO.delete(object);
    }

    @Override
    public List<Conversation> readAll() {
        return ConversationDAO.readAll();
    }
}
