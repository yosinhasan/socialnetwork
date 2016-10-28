package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.model.ConnectionsModel;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlConnectionDAO implements ConnectionDAO {
    @Override
    public Boolean create(ConnectionsModel object) {
        return null;
    }

    @Override
    public ConnectionsModel read(BigInteger id) {
        return null;
    }

    @Override
    public Boolean update(ConnectionsModel object) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public ConnectionsModel read(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<ConnectionsModel> readAll() {
        return null;
    }
}
