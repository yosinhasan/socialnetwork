package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.model.UsersModel;
import com.kindhope.service.UserService;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class UserServiceDAO implements UserService {
    private UserDAO userDAO;

    public UserServiceDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Boolean create(UsersModel object) {
        return userDAO.create(object);
    }

    @Override
    public UsersModel read(BigInteger id) {
        return userDAO.read(id);
    }

    @Override
    public Boolean update(UsersModel object) {
        return userDAO.update(object);
    }

    @Override
    public Boolean delete(Long id) {
        return userDAO.delete(id);
    }

    @Override
    public UsersModel read(String field, Object value) {
        return userDAO.read(field, value);
    }

    @Override
    public ArrayList<UsersModel> readAll() {
        return userDAO.readAll();
    }
}
