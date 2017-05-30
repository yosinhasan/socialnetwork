package com.kindhope.service;

import com.kindhope.entity.Message;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface MessageService extends GenericService<Message> {
    List<Message> findConversationMessages(BigInteger conversationId);

    Message findLastMessage(BigInteger conversationId);

    boolean addSeenAtTimestamp(BigInteger conversationId, BigInteger userId);

}
