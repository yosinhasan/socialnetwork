package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
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
public class ConnectionDAOImpl extends AbstractPKDAOImpl<Connection, ConnectionPK> implements ConnectionDAO {
    private static final Logger LOG = Logger.getLogger(ConnectionDAOImpl.class);

    @Transactional
    @Override
    public List<Connection> readAll() {
        return getSession().createQuery("select c from Connection c").getResultList();
    }

    @Transactional
    @Override
    public Connection read(Class<Connection> connectionClass, ConnectionPK connectionPK) {
        return getSession().get(connectionClass, connectionPK);
    }

    @Transactional
    @Override
    public List<User> findConnections(BigInteger userId) {
        LOG.debug("FIND CONNECTIONS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select c.friendId from Connection c where c.userId = :userId)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.debug("FIND CONNECTIONS BY  USER ID END");
        return list;
    }
}
