package com.kindhope.dao;

import com.kindhope.entity.Message;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface MessageDAO extends GenericDAO<Message> {

    List<Message> findConversationMessages(BigInteger conversationId);

    Message findLastMessage(BigInteger conversationId);

    List<Message> findUserConversationsLastMessages(List<BigInteger> conversationIds);

    List<Message> findUserConversationsLastMessages(BigInteger userId);

    List<Message> findUserConversationsLastMessagesWithUnseenCount(List<BigInteger> conversationIds);

    List<Message> findUserConversationsLastMessagesWithUnseenCount(BigInteger userId);

    boolean addSeenAtTimestamp(BigInteger conversationId, BigInteger userId);
}
