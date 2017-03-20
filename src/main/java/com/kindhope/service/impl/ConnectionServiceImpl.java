package com.kindhope.service.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
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
}
