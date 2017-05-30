package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
import com.kindhope.entity.User;
import com.kindhope.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    private ConnectionDAO connectionDAO;

    @Override
    public Connection read(BigInteger id) {
        return connectionDAO.read(Connection.class, id);
    }

    @Override
    public BigInteger create(Connection object) {
        return connectionDAO.create(object);
    }

    @Override
    public void update(Connection object) {
        connectionDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        connectionDAO.delete(object);
    }

    @Override
    public List<Connection> readAll() {
        return connectionDAO.readAll();
    }

    @Override
    public Connection read(Class<Connection> connectionClass, ConnectionPK connectionPK) {
        return connectionDAO.read(connectionClass, connectionPK);
    }

    @Override
    public ConnectionPK save(Connection object) {
        return connectionDAO.save(object);
    }

    @Override
    public void restoreConnection(BigInteger userId, BigInteger friendId) {
        connectionDAO.restoreConnection(userId, friendId);
    }

    @Override
    public void removeConnection(BigInteger userId, BigInteger friendId) {
        connectionDAO.removeConnection(userId, friendId);
    }

    @Override
    public Long countFollowings(BigInteger userId) {
        return connectionDAO.countFollowings(userId);
    }

    @Override
    public Long countFollowers(BigInteger userId) {
        return connectionDAO.countFollowers(userId);
    }

    @Override
    public Long countConnections(BigInteger userId) {
        return connectionDAO.countConnections(userId);
    }

    @Override
    public List<User> findFollowing(BigInteger userId) {
        return connectionDAO.findFollowing(userId);
    }

    @Override
    public List<User> findFollowers(BigInteger userId) {
        return connectionDAO.findFollowers(userId);
    }

    @Override
    public List<User> findConnections(BigInteger userId) {
        return connectionDAO.findConnections(userId);
    }
}
