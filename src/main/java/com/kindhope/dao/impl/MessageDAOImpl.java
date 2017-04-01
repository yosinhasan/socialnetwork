package com.kindhope.dao.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.Conversation;
import com.kindhope.entity.Message;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class MessageDAOImpl extends AbstractDAOImpl<Message> implements MessageDAO {
    private static final Logger LOG = Logger.getLogger(MessageDAOImpl.class);

    @Transactional
    @Override
    public List<Message> readAll() {
        return getSession().createQuery("select u from Message u", Message.class).getResultList();
    }

    @Transactional
    @Override
    public List<Message> findConversationMessages(BigInteger conversationId) {
        LOG.debug("FIND CONVERSATION MESSAGES BY ID START");
        LOG.debug("CONVERSATION ID" + conversationId);
        Query<Message> query = getSession().createQuery("from Message m where m.conversationId = :id", Message.class);
        query.setParameter("id", conversationId);
        List<Message> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND CONVERSATION MESSAGES BY ID END");
        return list;
    }

    @Transactional
    @Override
    public Message findLastMessage(BigInteger conversationId) {
        LOG.debug("FIND LAST MESSAGE BY ID START");
        LOG.debug("CONVERSATION ID" + conversationId);
        Query<Message> query = getSession().createQuery("from Message m where m.conversationId = :id order by m.id desc", Message.class);
        query.setParameter("id", conversationId);
        query.setMaxResults(1);
        Message message = query.uniqueResult();
        LOG.trace("FOUND DATA: " + message);
        LOG.debug("FIND LAST MESSAGE BY ID END");
        return message;
    }

    @Override
    public List<Message> findUserConversationsLastMessages(List<BigInteger> conversationIds) {
        LOG.debug("FIND USER CONVERSATIONS WITH LAST MESSAGE BY CONVERSATION IDS START");
        LOG.trace("CONVERSATION IDS" + conversationIds);
        List<Message> list = null;
        Query<Message> query = getSession().createQuery("from Message m where m.id in (select max(id) from Message where conversationId in (:ids) group by conversationId) order by m.id", Message.class);
        query.setParameter("ids", conversationIds);
        list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND USER CONVERSATIONS WITH LAST MESSAGE BY CONVERSATION IDS END");
        return list;
    }
}
