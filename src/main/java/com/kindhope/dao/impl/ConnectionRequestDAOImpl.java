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
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.userId from ConnectionRequest c where c.requestId = :userId)", User.class);
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
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.requestId from ConnectionRequest c where c.userId = :userId)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.debug("FIND CONNECTION SENT REQUESTS BY  USER ID END");
        return list;
    }

    @Override
    public void removeRequest(BigInteger userId, BigInteger requestId) {

    }

    @Override
    public void restoreRequest(BigInteger userId, BigInteger requestId) {

    }

    @Override
    public Long countRequests(BigInteger userId) {
        return null;
    }
}
