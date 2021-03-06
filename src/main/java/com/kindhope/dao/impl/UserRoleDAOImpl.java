package com.kindhope.dao.impl;

import com.kindhope.dao.UserRoleDAO;
import com.kindhope.entity.UserRole;
import com.kindhope.entity.UserRolePK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class UserRoleDAOImpl extends AbstractPKDAOImpl<UserRole, UserRolePK> implements UserRoleDAO {
    @Transactional
    @Override
    public List<UserRole> readAll() {
        return getSession().createQuery("select ur from UserRole  ur", UserRole.class).getResultList();
    }

    @Transactional
    @Override
    public UserRole read(Class<UserRole> userRoleClass, UserRolePK userRolePK) {
        return getSession().get(userRoleClass, userRolePK);
    }
}
