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
public class HibernateUserDAO implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean create(UsersEntity object) {
        getSession().save(object);
        return true;
    }

    @Override
    public UsersEntity read(BigInteger id) {
        return getSession().load(UsersEntity.class, id);
    }

    @Override
    public Boolean update(UsersEntity object) {
        getSession().update(object);
        return true;
    }

    @Override
    public Boolean delete(Object object) {
        getSession().delete(object);
        return true;

    }

    @Override
    public UsersEntity read(String field, Object value) {
        return getSession().
                createQuery("select UsersEntity from UsersEntity where :field = :val", UsersEntity.class)
                .setParameter("field", field)
                .setParameter("val", value)
                .getSingleResult();
    }

    @Transactional
    @Override
    public List<UsersEntity> readAll() {
        return getSession().createQuery("select u from UsersEntity u", UsersEntity.class).getResultList();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
