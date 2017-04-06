package com.kindhope.dao.impl;

import com.kindhope.dao.ConversationDAO;
import com.kindhope.entity.Conversation;
import com.kindhope.helper.exception.Error;
import com.kindhope.web.exception.DAOException;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
@Transactional
public class ConversationDAOImpl extends AbstractDAOImpl<Conversation> implements ConversationDAO {
    private static final Logger LOG = Logger.getLogger(ConversationDAOImpl.class);

    @Override
    public List<Conversation> readAll() {
        return getSession().createQuery("select c from Conversation c", Conversation.class).getResultList();
    }

    @Override
    public List<Conversation> findUserConversations(BigInteger userId) {
        LOG.debug("FIND USER CONVERSATIONS BY USER ID START");
        LOG.trace("USER ID" + userId);
        Query<Conversation> query = getSession().createQuery("from Conversation c " +
                "where c.deletedAt is null and (c.userId = :id or c.friendId = :id) and c.id not in (select dc.conversationId from DeletedConversation dc where dc.userId = :id and dc.deletedAt is null)", Conversation.class);
        query.setParameter("id", userId);
        List<Conversation> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND USER CONVERSATIONS BY USER ID END");
        return list;
    }

    @Override
    public List<BigInteger> findUserConversationIds(BigInteger userId) {
        LOG.debug("FIND USER CONVERSATIONS BY USER ID START");
        LOG.trace("USER ID" + userId);
        Query<BigInteger> query = getSession().createQuery("select c.id from Conversation c " +
                "where c.deletedAt is null and (c.userId = :id or c.friendId = :id) and c.id not in (select dc.conversationId from DeletedConversation  dc where dc.userId = :id and dc.deletedAt is null)", BigInteger.class);
        query.setParameter("id", userId);
        List<BigInteger> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND USER CONVERSATIONS BY USER ID END");
        return list;
    }

    @Override
    public Conversation findConversationWithMessages(BigInteger conversationId) {
        LOG.debug("FIND CONVERSATION WITH MESSAGES BY CONVERSATION ID START");
        LOG.trace("CONVERSATION ID" + conversationId);
        Conversation conversation = null;
        try {
            Query<Conversation> query = getSession().createQuery("from Conversation c where c.id = :id and c.deletedAt is null",
                    Conversation.class);
            query.setParameter("id", conversationId);
            conversation = query.getSingleResult();
            Hibernate.initialize(conversation.getMessages());
        } catch (Throwable e) {
            LOG.error("ERROR OCCURED " + e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        LOG.trace("FOUND DATA: " + conversation);
        LOG.debug("FIND CONVERSATION WITH MESSAGES BY CONVERSATION ID END");
        return conversation;
    }

    @Override
    public void setConversationLastMessageId(BigInteger conversationId, BigInteger messageId) {
        LOG.debug("SET LAST MESSAGE ID FOR CONVERSATION START");
        LOG.trace("CONVERSATION ID" + conversationId);
        LOG.trace("MESSAGE ID" + messageId);
        Conversation conversation = null;
        try {
            Query query = getSession().createQuery("update Conversation set lastMessageId = :messageId where id = :conversationId");
            query.setParameter("messageId", messageId);
            query.setParameter("conversationId", conversationId);
            int affectedRows = query.executeUpdate();
            if (affectedRows <= 0) {
                throw new Exception(Error.CONVERSATION_NOT_UPDATED);
            }
        } catch (Throwable e) {
            LOG.error("ERROR OCCURED " + e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        LOG.trace("FOUND DATA: " + conversation);
        LOG.debug("SET LAST MESSAGE ID FOR CONVERSATION END");
    }

    @Override
    public Long countConversationUnseenMessagesQuantity(BigInteger userId) {
        LOG.debug("COUNT QUANTITY OF CONVERSATION UNSEEN MESSAGES START");
        LOG.trace("USER ID" + userId);
        Query<Long> query = getSession().createQuery("select count(m.id) from Message m where m.deletedAt is null and m.seenAt is null and m.id in " +
                "(select c.id from Conversation c where c.deletedAt is null and (c.userId = :userId or c.friendId = :userId) and c.id not in (select dc.conversationId from DeletedConversation  dc where dc.userId = :userId and dc.deletedAt is null))", Long.class);
        query.setParameter("userId", userId);
        Long data = query.uniqueResult();
        LOG.trace("FOUND DATA: " + data);
        LOG.debug("COUNT QUANTITY OF CONVERSATION UNSEEN MESSAGES END");
        return data;
    }
}
