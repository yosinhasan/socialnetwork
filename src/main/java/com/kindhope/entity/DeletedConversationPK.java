package com.kindhope.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class DeletedConversationPK implements Serializable {
    private BigInteger userId;
    private BigInteger conversationId;

    @Column(name = "user_id")
    @Id
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Column(name = "conversation_id")
    @Id
    public BigInteger getConversationId() {
        return conversationId;
    }

    public void setConversationId(BigInteger conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeletedConversationPK that = (DeletedConversationPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (conversationId != null ? !conversationId.equals(that.conversationId) : that.conversationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        return result;
    }
}
