package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
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
@Transactional
@Repository
public class ConnectionDAOImpl extends AbstractPKDAOImpl<Connection, ConnectionPK> implements ConnectionDAO {

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
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)" +
                " and u.id  in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public List<User> findFollowers(BigInteger userId) {
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is not null)" +
                " and u.id in (select c.userId from Connection c where c.friendId = :userId and (c.deletedAt is null))", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public List<User> findFollowing(BigInteger userId) {
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u " +
                "where u.id in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is not null)" +
                " and  u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)", User.class);
        query.setParameter("userId", userId);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void removeConnection(BigInteger userId, BigInteger friendId) {
        Query query = getSession().createQuery("update Connection set deletedAt = current_timestamp() where userId =:userId and friendId = :friendId");
        query.setParameter("userId", userId);
        query.setParameter("friendId", friendId);
        int affectedRow = query.executeUpdate();
        if (affectedRow <= 0) {
            throw new DAOException(Error.CONNECTION_NOT_REMOVED);
        }
    }

    @Override
    public void restoreConnection(BigInteger userId, BigInteger friendId) {
        Query query = getSession().createQuery("update Connection set deletedAt = null, updatedAt = current_timestamp() where userId =:userId and friendId = :friendId");
        query.setParameter("userId", userId);
        query.setParameter("friendId", friendId);
        int affectedRow = query.executeUpdate();
        if (affectedRow <= 0) {
            throw new DAOException(Error.CONNECTION_NOT_RESTORED);
        }
    }

    @Override
    public Long countConnections(BigInteger userId) {
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)" +
                " and u.id  in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is null)", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        return count;
    }

    @Override
    public Long countFollowers(BigInteger userId) {
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is not null)" +
                " and u.id in (select c.userId from Connection c where c.friendId = :userId and (c.deletedAt is null))", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        return count;
    }

    @Override
    public Long countFollowings(BigInteger userId) {
        Query<Long> query = getSession().createQuery("select count(u.id) from User u " +
                "where u.id in (select c.userId from Connection c where c.friendId = :userId and c.deletedAt is not null)" +
                " and  u.id in (select c.friendId from Connection c where c.userId = :userId and c.deletedAt is null)", Long.class);
        query.setParameter("userId", userId);
        Long count = query.uniqueResult();
        return count;

    }

}
