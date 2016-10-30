package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.ConnectionsEntity;
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
public class ConnectionServiceImpl implements ConnectionService {

    private ConnectionDAO connectionDAO;

    public ConnectionServiceImpl(ConnectionDAO connectionDAO) {
        this.connectionDAO = connectionDAO;
    }
    @Override
    public ConnectionsEntity read( BigInteger id) {
        return connectionDAO.read(ConnectionsEntity.class, id);
    }

    @Override
    public Boolean create(ConnectionsEntity object) {
        return connectionDAO.create(object);
    }

    @Override
    public Boolean update(ConnectionsEntity object) {
        return connectionDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return connectionDAO.delete(object);
    }

    @Override
    public List<ConnectionsEntity> readAll() {
        return connectionDAO.readAll();
    }
}
