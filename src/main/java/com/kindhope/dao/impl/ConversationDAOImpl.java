package com.kindhope.dao.impl;

import com.kindhope.dao.ConversationDAO;
import com.kindhope.entity.Conversation;
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
                "where (c.userId = :id or c.friendId = :id) and c.id not in (select dc.conversationId from DeletedConversation  dc where dc.userId = :id)", Conversation.class);
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
                "where (c.userId = :id or c.friendId = :id) and c.id not in (select dc.conversationId from DeletedConversation  dc where dc.userId = :id)", BigInteger.class);
        query.setParameter("id", userId);
        List<BigInteger> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND USER CONVERSATIONS BY USER ID END");
        return list;
    }

    @Override
    public Conversation findWithMessages(BigInteger conversationId) {
        LOG.debug("FIND CONVERSATION WITH MESSAGES BY CONVERSATION ID START");
        LOG.trace("CONVERSATION ID" + conversationId);
        Conversation conversation = null;
        try {
            Query<Conversation> query = getSession().createQuery("from Conversation c where c.id = :id",
                    Conversation.class);
            query.setParameter("id", conversationId);
            conversation = query.getSingleResult();
            Hibernate.initialize(conversation.getMessages());
        } catch (Throwable e) {
            LOG.error("ERROR OCCURED " + e.getMessage());
        }
        LOG.trace("FOUND DATA: " + conversation);
        LOG.debug("FIND CONVERSATION WITH MESSAGES BY CONVERSATION ID END");
        return conversation;
    }
}
