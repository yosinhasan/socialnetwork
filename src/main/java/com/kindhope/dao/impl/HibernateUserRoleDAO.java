package com.kindhope.dao.impl;

import com.kindhope.dao.UserRoleDAO;
import com.kindhope.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateUserRoleDAO extends AbstractHibernateDAO<UserRole> implements UserRoleDAO {

    @Override
    public List<UserRole> readAll() {
        return getSession().createQuery("select ur from UserRole  ur", UserRole.class).getResultList();
    }
}
