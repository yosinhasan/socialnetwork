package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.model.ConnectionsModel;
import com.kindhope.service.ConnectionService;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class ConnectionRequestServiceDAO implements ConnectionService {
    private ConnectionDAO connectionDAO;

    public ConnectionRequestServiceDAO(ConnectionDAO connectionDAO) {
        this.connectionDAO = connectionDAO;
    }

    @Override
    public Boolean create(ConnectionsModel object) {
        return connectionDAO.create(object);
    }

    @Override
    public ConnectionsModel read(BigInteger id) {
        return connectionDAO.read(id);
    }

    @Override
    public Boolean update(ConnectionsModel object) {
        return connectionDAO.update(object);
    }

    @Override
    public Boolean delete(Long id) {
        return connectionDAO.delete(id);
    }

    @Override
    public ConnectionsModel read(String field, Object value) {
        return connectionDAO.read(field, value);
    }

    @Override
    public ArrayList<ConnectionsModel> readAll() {
        return connectionDAO.readAll();
    }
}
