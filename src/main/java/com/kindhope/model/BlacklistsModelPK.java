package com.kindhope.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class BlacklistsModelPK implements Serializable {
    private Long userId;
    private Long blockedUserId;

    @Column(name = "user_id")
    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "blocked_user_id")
    @Id
    public Long getBlockedUserId() {
        return blockedUserId;
    }

    public void setBlockedUserId(Long blockedUserId) {
        this.blockedUserId = blockedUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlacklistsModelPK that = (BlacklistsModelPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (blockedUserId != null ? !blockedUserId.equals(that.blockedUserId) : that.blockedUserId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (blockedUserId != null ? blockedUserId.hashCode() : 0);
        return result;
    }
}
