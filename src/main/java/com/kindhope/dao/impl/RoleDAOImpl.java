package com.kindhope.dao.impl;

import com.kindhope.dao.RoleDAO;
import com.kindhope.entity.Role;
import com.kindhope.helper.exception.Error;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class RoleDAOImpl extends AbstractDAOImpl<Role> implements RoleDAO {
    @Transactional
    @Override
    public Role read(Class<Role> roleClass, BigInteger id) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Transactional
    @Override
    public BigInteger create(Role object) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Transactional
    @Override
    public List<Role> readAll() {
        return getSession().createQuery("select r from Role r", Role.class).getResultList();
    }

    @Transactional
    @Override
    public Integer save(Role object) {
        return (Integer) getSession().save(object);
    }

    @Transactional
    @Override
    public Role read(Integer id) {
        return getSession().get(Role.class, id);
    }
}
