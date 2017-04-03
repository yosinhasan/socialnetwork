package com.kindhope.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "message", schema = "kindhope", catalog = "")
public class Message {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger conversationId;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Timestamp seenAt;
    private Conversation conversationById;

    public Message() {

    }

    public Message(BigInteger id, BigInteger userId, BigInteger conversationId, String content) {
        this.id = id;
        this.userId = userId;
        this.conversationId = conversationId;
        this.content = content;
//        this.seenAt = seenAt;
    }

    public Message(BigInteger id, BigInteger userId, BigInteger conversationId, String content, Timestamp seenAt) {
        this.id = id;
        this.userId = userId;
        this.conversationId = conversationId;
        this.content = content;
        this.seenAt = seenAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "conversation_id")
    public BigInteger getConversationId() {
        return conversationId;
    }

    public void setConversationId(BigInteger friendId) {
        this.conversationId = friendId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Basic
    @Column(name = "seen_at")
    public Timestamp getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(Timestamp seenAt) {
        this.seenAt = seenAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (userId != null ? !userId.equals(message.userId) : message.userId != null) return false;
        if (conversationId != null ? !conversationId.equals(message.conversationId) : message.conversationId != null)
            return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (createdAt != null ? !createdAt.equals(message.createdAt) : message.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(message.updatedAt) : message.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(message.deletedAt) : message.deletedAt != null) return false;
        return seenAt != null ? seenAt.equals(message.seenAt) : message.seenAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        result = 31 * result + (seenAt != null ? seenAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Conversation getConversationById() {
        return conversationById;
    }

    public void setConversationById(Conversation conversationById) {
        this.conversationById = conversationById;
    }

}
