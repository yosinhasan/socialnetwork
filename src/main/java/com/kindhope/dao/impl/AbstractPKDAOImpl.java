package com.kindhope.dao.impl;

import com.kindhope.dao.GenericPKDAO;
import com.kindhope.helper.exception.Error;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;


/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
public abstract class AbstractPKDAOImpl<T, PK> extends AbstractDAOImpl<T> implements GenericPKDAO<T, PK> {

    @Transactional
    @Override
    public T read(Class<T> blacklistClass, BigInteger id) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Transactional
    @Override
    public void update(T object) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Transactional
    @Override
    public BigInteger create(T object) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Override
    public PK save(T object) {
        return (PK) getSession().save(object);
    }
}
