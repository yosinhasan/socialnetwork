package com.kindhope.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "conversation", schema = "kindhope", catalog = "")
public class Conversation {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger friendId;
    private BigInteger lastMessageId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Collection<DeletedConversation> deletedConversationsById;
    private Collection<Message> messages;
    private Message lastMessage;

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
    @Column(name = "friend_id")
    public BigInteger getFriendId() {
        return friendId;
    }

    public void setFriendId(BigInteger friendId) {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "last_message_id")
    public BigInteger getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(BigInteger lastMessageId) {
        this.lastMessageId = lastMessageId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (friendId != null ? !friendId.equals(that.friendId) : that.friendId != null) return false;
        if (lastMessageId != null ? !lastMessageId.equals(that.lastMessageId) : that.lastMessageId != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        return deletedAt != null ? deletedAt.equals(that.deletedAt) : that.deletedAt == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (friendId != null ? friendId.hashCode() : 0);
        result = 31 * result + (lastMessageId != null ? lastMessageId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "conversationByConversationId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<DeletedConversation> getDeletedConversationsById() {
        return deletedConversationsById;
    }

    public void setDeletedConversationsById(Collection<DeletedConversation> deletedConversationsById) {
        this.deletedConversationsById = deletedConversationsById;
    }

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "conversationById", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messagesById) {
        this.messages = messagesById;
    }

    @ManyToOne
    @JoinColumn(name = "last_message_id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

}
