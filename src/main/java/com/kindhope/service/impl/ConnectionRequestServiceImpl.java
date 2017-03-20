package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
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
}
