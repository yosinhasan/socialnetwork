package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.model.ConnectionRequestsModel;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlConnectionRequestDAO implements ConnectionRequestDAO {
    @Override
    public Boolean create(ConnectionRequestsModel object) {
        return null;
    }

    @Override
    public ConnectionRequestsModel read(BigInteger id) {
        return null;
    }

    @Override
    public Boolean update(ConnectionRequestsModel object) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public ConnectionRequestsModel read(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<ConnectionRequestsModel> readAll() {
        return null;
    }
}
