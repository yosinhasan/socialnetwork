package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequestsEntity;
import com.kindhope.service.ConnectionRequestService;
import com.kindhope.service.ConnectionService;
import com.kindhope.service.GenericService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class ConnectionRequestServiceImpl implements ConnectionRequestService {

    private ConnectionRequestDAO connectionRequestDAO;

    public ConnectionRequestServiceImpl(ConnectionRequestDAO connectionRequestDAO) {
        this.connectionRequestDAO = connectionRequestDAO;
    }
    @Override
    public ConnectionRequestsEntity read(BigInteger id) {
        return connectionRequestDAO.read(ConnectionRequestsEntity.class, id);
    }

    @Override
    public Boolean create(ConnectionRequestsEntity object) {
        return connectionRequestDAO.create(object);
    }

    @Override
    public Boolean update(ConnectionRequestsEntity object) {
        return connectionRequestDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return connectionRequestDAO.delete(object);
    }

    @Override
    public List<ConnectionRequestsEntity> readAll() {
        return connectionRequestDAO.readAll();
    }
}
