package com.kindhope.dao.impl;

import com.kindhope.dao.MessageDAO;
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

    @Override
    public List<Message> findUserConversationsLastMessages(BigInteger userId) {
        LOG.debug("FIND USER CONVERSATIONS WITH LAST MESSAGE BY USER ID START");
        LOG.trace("USER ID" + userId);
        List<Message> list = null;
        Query<Message> query = getSession().createQuery("from Message m where m.id in " +
                "(select max(id) from Message where conversationId in (" +
                "select id from Conversation where (userId = :id or friendId = :id)" +
                "and id not in (select conversationId from DeletedConversation where userId = :id)) " +
                "group by conversationId) order by m.id", Message.class);
        query.setParameter("id", userId);
        list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND USER CONVERSATIONS WITH LAST MESSAGE BY USER ID END");
        return list;
    }

    @Override
    public List<Message> findUserConversationsLastMessagesWithUnseenCount(List<BigInteger> conversationIds) {
        return null;
    }

    @Override
    public List<Message> findUserConversationsLastMessagesWithUnseenCount(BigInteger userId) {
        return null;
    }

    @Override
    public boolean addSeenAtTimestamp(BigInteger conversationId, BigInteger userId) {
        LOG.debug("ADD TIMESTAMP FOR SEEN AT BY USER ID AND CONVERSATION ID START");
        LOG.trace("USER ID" + userId);
        LOG.trace("CONVERSATION ID" + conversationId);
        List<Message> list = null;
        Query<Message> query = getSession().createQuery("update Message set seenAt = CURRENT_TIMESTAMP() where " +
                "(seenAt = '' or seenAt is null) and conversationId = :conversationId and userId != :userId");
        query.setParameter("conversationId", conversationId);
        query.setParameter("userId", userId);
        int affectedRows = query.executeUpdate();
        LOG.trace("UPDATED ROWS: " + affectedRows);
        LOG.debug("ADD TIMESTAMP FOR SEEN AT BY USER ID AND CONVERSATION ID END");
        return affectedRows > 0;
    }

}
