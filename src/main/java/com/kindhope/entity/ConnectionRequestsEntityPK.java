package com.kindhope.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ConnectionRequestsEntityPK implements Serializable {
    private BigInteger userId;
    private BigInteger requestId;

    @Column(name = "user_id")
    @Id
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Column(name = "request_id")
    @Id
    public BigInteger getRequestId() {
        return requestId;
    }

    public void setRequestId(BigInteger requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionRequestsEntityPK that = (ConnectionRequestsEntityPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        return result;
    }
}
