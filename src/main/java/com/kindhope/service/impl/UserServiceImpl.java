package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.UsersEntity;
import com.kindhope.service.UserService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Boolean create(UsersEntity object) {
        return userDAO.create(object);
    }

    @Override
    public UsersEntity read(BigInteger id) {
        return userDAO.read(UsersEntity.class, id);
    }

    @Override
    public Boolean update(UsersEntity object) {
        return userDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return userDAO.delete(object);
    }

    @Override
    public List<UsersEntity> readAll() {
        return userDAO.readAll();
    }
}