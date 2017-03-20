package com.kindhope.dao.impl;

import com.kindhope.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public abstract class AbstractHibernateDAO<T> implements GenericDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public BigInteger create(T object) {
        return (BigInteger) getSession().save(object);
    }

    @Transactional
    @Override
    public T read(Class<T> tClass, BigInteger id) {
        return getSession().load(tClass, id);
    }

    @Transactional
    @Override
    public void update(T object) {
        getSession().update(object);
    }

    @Transactional
    @Override
    public void delete(Object object) {
        getSession().delete(object);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
