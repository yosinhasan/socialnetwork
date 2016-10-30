package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateUserDAO extends AbstractHibernateDAO<UsersEntity> implements UserDAO {

    @Transactional
    @Override
    public List<UsersEntity> readAll() {
        return getSession().createQuery("select u from UsersEntity u", UsersEntity.class).getResultList();
    }

}
