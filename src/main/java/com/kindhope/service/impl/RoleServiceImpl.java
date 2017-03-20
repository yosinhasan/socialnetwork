package com.kindhope.service.impl;

import com.kindhope.dao.RoleDAO;
import com.kindhope.entity.Role;
import com.kindhope.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public BigInteger create(Role object) {
        return roleDAO.create(object);
    }

    public Role read(BigInteger id) {
        return roleDAO.read(Role.class, id);
    }

    @Override
    public void update(Role object) {
        roleDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        roleDAO.delete(object);
    }

    @Override
    public List<Role> readAll() {
        return roleDAO.readAll();
    }

    @Override
    public Integer save(Role object) {
        return roleDAO.createAndReturnIntId(object);
    }

    @Override
    public Role read(Integer id) {
        return roleDAO.read(id);
    }
}
