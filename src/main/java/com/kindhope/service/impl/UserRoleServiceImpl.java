package com.kindhope.service.impl;

import com.kindhope.dao.UserRoleDAO;
import com.kindhope.entity.UserRole;
import com.kindhope.entity.UserRolePK;
import com.kindhope.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;

    public BigInteger create(UserRole object) {
        return userRoleDAO.create(object);
    }

    public void update(UserRole object) {
        userRoleDAO.update(object);
    }

    public UserRole read(BigInteger id) {
        return userRoleDAO.read(UserRole.class, id);
    }

    @Override
    public void delete(Object object) {
        userRoleDAO.delete(object);
    }

    @Override
    public List<UserRole> readAll() {
        return userRoleDAO.readAll();
    }

    @Override
    public UserRole read(Class<UserRole> userRoleClass, UserRolePK userRolePK) {
        return userRoleDAO.read(userRoleClass, userRolePK);
    }

    @Override
    public UserRolePK save(UserRole object) {
        return userRoleDAO.save(object);
    }
}
