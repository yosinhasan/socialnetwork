package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.model.UsersModel;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlUserDAO implements UserDAO {
    @Override
    public Boolean create(UsersModel object) {
        return null;
    }

    @Override
    public UsersModel read(BigInteger id) {
        return null;
    }

    @Override
    public Boolean update(UsersModel object) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public UsersModel read(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<UsersModel> readAll() {
        return null;
    }
}
