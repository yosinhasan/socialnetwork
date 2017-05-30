package com.kindhope.service;

import com.kindhope.entity.Conversation;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface ConversationService extends GenericService<Conversation> {
    List<Conversation> findUserConversations(BigInteger userId);

    List<BigInteger> findUserConversationIds(BigInteger userId);

    Conversation findConversationWithMessages(BigInteger conversationId);

    void setConversationLastMessageId(BigInteger conversationId, BigInteger messageId);

    Long countConversationUnseenMessagesQuantity(BigInteger userId);

}
