package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import com.kindhope.entity.User;
import com.kindhope.helper.exception.Error;
import com.kindhope.web.exception.DAOException;
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
public class ConnectionRequestDAOImpl extends AbstractPKDAOImpl<ConnectionRequest, ConnectionRequestPK> implements ConnectionRequestDAO {

    @Transactional
    @Override
    public List<ConnectionRequest> readAll() {
        return getSession().createQuery("select cr from ConnectionRequest cr", ConnectionRequest.class).getResultList();
    }

    @Transactional
    @Override
    public ConnectionRequest read(Class<ConnectionRequest> connectionRequestClass, ConnectionRequestPK connectionRequestPK) {
        return getSession().get(connectionRequestClass, connectionRequestPK);
    }

    @Transactional
    @Override
    public List<User> findReceivedRequests(BigInteger userId) {
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.userId from ConnectionRequest c where c.requestId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<User> findSentRequests(BigInteger userId) {
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.requestId from ConnectionRequest c where c.userId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void removeRequest(BigInteger userId, BigInteger requestId) {
        Query query = getSession().createQuery("update ConnectionRequest set deletedAt = current_timestamp() where userId =:userId and requestId = :requestId");
        query.setParameter("userId", userId);
        query.setParameter("requestId", requestId);
        int affectedRow = query.executeUpdate();
        if (affectedRow <= 0) {
            throw new DAOException(Error.CONNECTION_REQUEST_NOT_REMOVED);
        }
    }

    @Override
    public void restoreRequest(BigInteger userId, BigInteger requestId) {
        Query query = getSession().createQuery("update ConnectionRequest set deletedAt = null, updatedAt = current_timestamp() where userId =:userId and requestId = :requestId");
        query.setParameter("userId", userId);
        query.setParameter("requestId", requestId);
        int affectedRow = query.executeUpdate();
        if (affectedRow <= 0) {
            throw new DAOException(Error.CONNECTION_NOT_RESTORED);
        }
    }

    @Override
    public Long countRequests(BigInteger userId) {
        Query<Long> query = getSession().createQuery("select count(c.userId) from ConnectionRequest c where c.requestId = :userId and c.deletedAt is null", Long.class);
        query.setParameter("userId", userId);
        long count = query.uniqueResult();
        return count;
    }
}
