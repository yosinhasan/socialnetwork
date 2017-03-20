package com.kindhope.dao.impl;

import com.kindhope.dao.RoleDAO;
import com.kindhope.entity.Role;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateRoleDAO extends AbstractHibernateDAO<Role> implements RoleDAO {

    @Override
    public Role read(Class<Role> roleClass, BigInteger id) {
        throw new RuntimeException("Method not implemented");
    }

    @Override
    public BigInteger create(Role object) {
        throw new RuntimeException("Method not implemented");
    }

    @Override
    public List<Role> readAll() {
        return getSession().createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Integer createAndReturnIntId(Role object) {
        return (Integer) getSession().save(object);
    }

    @Override
    public Role read(Integer id) {
        return getSession().load(Role.class, id);
    }
}
