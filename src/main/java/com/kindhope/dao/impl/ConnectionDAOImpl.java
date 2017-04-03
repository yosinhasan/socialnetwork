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
@Transactional
@Repository
public class ConnectionDAOImpl extends AbstractPKDAOImpl<Connection, ConnectionPK> implements ConnectionDAO {
    private static final Logger LOG = Logger.getLogger(ConnectionDAOImpl.class);

    @Override
    public List<Connection> readAll() {
        return getSession().createQuery("select c from Connection c").getResultList();
    }

    @Override
    public Connection read(Class<Connection> connectionClass, ConnectionPK connectionPK) {
        return getSession().get(connectionClass, connectionPK);
    }

    @Override
    public List<User> findConnections(BigInteger userId) {
        LOG.debug("FIND CONNECTIONS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)" +
                " and u.id  in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND CONNECTIONS BY  USER ID END");
        return list;
    }

    @Override
    public List<User> findFollowers(BigInteger userId) {
        LOG.debug("FIND FOLLOWERS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is not null)" +
                " and u.id in (select c.userId from Connection c where c.friendId = :userId and (c.deletedAt is null))", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND FOLLOWERS BY  USER ID END");
        return list;
    }

    @Override
    public List<User> findFollowing(BigInteger userId) {
        LOG.debug("FIND FOLLOWING BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is not null)" +
                " and  u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        LOG.trace("FOUND DATA: " + list);
        LOG.debug("FIND FOLLOWING BY  USER ID END");
        return list;
    }

    @Override
    public void removeConnection(BigInteger userId, BigInteger friendId) {
        LOG.debug("REMOVE CONNECTION BY  USER ID AND FRIEND ID START");
        LOG.trace("USER ID: " + userId);
        LOG.trace("FRIEND ID: " + friendId);
        Query query = getSession().createQuery("update Connection set deletedAt = current_timestamp() where userId =:userId and friendId = :friendId");
        query.setParameter("userId", userId);
        query.setParameter("friendId", friendId);
        int affectedRow = query.executeUpdate();
        LOG.trace("Affected rows: " + affectedRow);
        LOG.debug("REMOVE CONNECTION BY  USER ID AND FRIEND ID END");
    }

    @Override
    public void restoreConnection(BigInteger userId, BigInteger friendId) {
        LOG.debug("RESTORE CONNECTION BY  USER ID AND FRIEND ID START");
        LOG.trace("USER ID: " + userId);
        LOG.trace("FRIEND ID: " + friendId);
        Query query = getSession().createQuery("update Connection set deletedAt = null, updatedAt = current_timestamp() where userId =:userId and friendId = :friendId");
        query.setParameter("userId", userId);
        query.setParameter("friendId", friendId);
        int affectedRow = query.executeUpdate();
        LOG.trace("Affected rows: " + affectedRow);
        LOG.debug("RESTORE CONNECTION BY  USER ID AND FRIEND ID END");
    }

    @Override
    public Long countConnections(BigInteger userId) {
        LOG.debug("COUNT CONNECTIONS BY  USER ID START");
        LOG.trace("USER ID" + userId);
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)" +
                " and u.id  in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is null)", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        LOG.trace("COUNT DATA: " + count);
        LOG.debug("COUNT CONNECTIONS BY  USER ID END");
        return count;
    }

    @Override
    public Long countFollowers(BigInteger userId) {
        LOG.debug("COUNT FOLLOWERS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is not null)" +
                " and u.id in (select c.userId from Connection c where c.friendId = :userId and (c.deletedAt is null))", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        LOG.trace("COUNT DATA: " + count);
        LOG.debug("COUNT FOLLOWERS BY  USER ID END");
        return count;
    }

    @Override
    public Long countFollowings(BigInteger userId) {
        LOG.debug("COUNT FOLLOWING BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is not null)" +
                " and  u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        LOG.trace("COUNT DATA: " + count);
        LOG.debug("COUNT FOLLOWING BY  USER ID END");
        return count;

    }

}
