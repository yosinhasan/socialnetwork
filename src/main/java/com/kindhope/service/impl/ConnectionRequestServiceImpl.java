package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import com.kindhope.entity.User;
import com.kindhope.service.ConnectionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class ConnectionRequestServiceImpl implements ConnectionRequestService {
    @Autowired
    private ConnectionRequestDAO connectionRequestDAO;


    @Override
    public ConnectionRequest read(BigInteger id) {
        return connectionRequestDAO.read(ConnectionRequest.class, id);
    }

    @Override
    public BigInteger create(ConnectionRequest object) {
        return connectionRequestDAO.create(object);
    }

    @Override
    public void update(ConnectionRequest object) {
        connectionRequestDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        connectionRequestDAO.delete(object);
    }

    @Override
    public List<ConnectionRequest> readAll() {
        return connectionRequestDAO.readAll();
    }

    @Override
    public ConnectionRequest read(Class<ConnectionRequest> connectionRequestClass, ConnectionRequestPK connectionRequestPK) {
        return connectionRequestDAO.read(connectionRequestClass, connectionRequestPK);
    }

    @Override
    public ConnectionRequestPK save(ConnectionRequest object) {
        return connectionRequestDAO.save(object);
    }

    @Override
    public Long countRequests(BigInteger userId) {
        return connectionRequestDAO.countRequests(userId);
    }

    @Override
    public void restoreRequest(BigInteger userId, BigInteger requestId) {
        connectionRequestDAO.restoreRequest(userId, requestId);
    }

    @Override
    public void removeRequest(BigInteger userId, BigInteger requestId) {
        connectionRequestDAO.removeRequest(userId, requestId);
    }

    @Override
    public List<User> findSentRequests(BigInteger userId) {
        return connectionRequestDAO.findSentRequests(userId);
    }

    @Override
    public List<User> findReceivedRequests(BigInteger userId) {
        return connectionRequestDAO.findReceivedRequests(userId);
    }
}
