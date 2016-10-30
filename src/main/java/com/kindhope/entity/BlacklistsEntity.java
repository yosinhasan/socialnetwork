package com.kindhope.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "blacklists", schema = "kindhope", catalog = "")
@IdClass(BlacklistsEntityPK.class)
public class BlacklistsEntity {
    private BigInteger userId;
    private BigInteger blockedUserId;
    private Timestamp createdAt;
    private UsersEntity usersByUserId;
    private UsersEntity usersByBlockedUserId;

    @Id
    @Column(name = "user_id")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "blocked_user_id")
    public BigInteger getBlockedUserId() {
        return blockedUserId;
    }

    public void setBlockedUserId(BigInteger blockedUserId) {
        this.blockedUserId = blockedUserId;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlacklistsEntity that = (BlacklistsEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (blockedUserId != null ? !blockedUserId.equals(that.blockedUserId) : that.blockedUserId != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (blockedUserId != null ? blockedUserId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "blocked_user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UsersEntity getUsersByBlockedUserId() {
        return usersByBlockedUserId;
    }

    public void setUsersByBlockedUserId(UsersEntity usersByBlockedUserId) {
        this.usersByBlockedUserId = usersByBlockedUserId;
    }
}
