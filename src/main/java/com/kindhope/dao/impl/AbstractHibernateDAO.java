package com.kindhope.dao.impl;

import com.kindhope.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public abstract class AbstractHibernateDAO<T> implements GenericDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public Boolean create(T object) {
        getSession().save(object);
        return true;
    }

    @Transactional
    @Override
    public T read(Class<T> tClass, BigInteger id) {
        return getSession().load(tClass, id);
    }

    @Transactional
    @Override
    public Boolean update(T object) {
        getSession().update(object);
        return true;
    }

    @Transactional
    @Override
    public Boolean delete(Object object) {
        getSession().delete(object);
        return true;
    }
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
