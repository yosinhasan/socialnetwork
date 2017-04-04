package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import com.kindhope.entity.User;
import org.apache.log4j.Logger;
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
    private static final Logger LOG = Logger.getLogger(ConnectionRequestDAOImpl.class);

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
        LOG.debug("FIND CONNECTION RECEIVED REQUESTS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.userId from ConnectionRequest c where c.requestId = :userId and deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.debug("FIND CONNECTION RECEIVED REQUESTS BY  USER ID END");
        return list;
    }

    @Transactional
    @Override
    public List<User> findSentRequests(BigInteger userId) {
        LOG.debug("FIND CONNECTION SENT REQUESTS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.requestId from ConnectionRequest c where c.userId = :userId and deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.debug("FIND CONNECTION SENT REQUESTS BY  USER ID END");
        return list;
    }

    @Override
    public void removeRequest(BigInteger userId, BigInteger requestId) {
        LOG.debug("REMOVE CONNECTION REQUEST BY  USER ID AND REQUEST ID START");
        LOG.trace("USER ID: " + userId);
        LOG.trace("REQUEST ID: " + requestId);
        Query query = getSession().createQuery("update ConnectionRequest set deletedAt = current_timestamp() where userId =:userId and requestId = :requestId");
        query.setParameter("userId", userId);
        query.setParameter("requestId", requestId);
        int affectedRow = query.executeUpdate();
        LOG.trace("Affected rows: " + affectedRow);
        LOG.debug("REMOVE CONNECTION REQUEST BY  USER ID AND REQUEST ID END");
    }

    @Override
    public void restoreRequest(BigInteger userId, BigInteger requestId) {
        LOG.debug("RESTORE CONNECTION REQUEST BY  USER ID AND REQUEST ID START");
        LOG.trace("USER ID: " + userId);
        LOG.trace("REQUEST ID: " + requestId);
        Query query = getSession().createQuery("update ConnectionRequest set deletedAt = null, updatedAt = current_timestamp() where userId =:userId and requestId = :requestId");
        query.setParameter("userId", userId);
        query.setParameter("requestId", requestId);
        int affectedRow = query.executeUpdate();
        LOG.trace("Affected rows: " + affectedRow);
        LOG.debug("RESTORE CONNECTION REQUEST BY  USER ID AND REQUEST ID END");
    }

    @Override
    public Long countRequests(BigInteger userId) {
        LOG.debug("COUNT CONNECTION RECEIVED REQUESTS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<Long> query = getSession().createQuery("select count(c.userId) from ConnectionRequest c where c.requestId = :userId and deletedAt is null", Long.class);
        query.setParameter("userId", userId);
        long count = query.uniqueResult();
        LOG.trace("COUNT DATA: " + count);
        LOG.debug("COUNT CONNECTION RECEIVED REQUESTS BY  USER ID END");
        return count;
    }
}
