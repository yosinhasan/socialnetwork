package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
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
public class HibernateBlacklistDAO extends AbstractHibernateDAO<Blacklist> implements BlacklistDAO {
    @Transactional
    @Override
    public List<Blacklist> readAll() {
        return getSession().createQuery("select b from Blacklist b").getResultList();
    }

    @Override
    public Blacklist read(BlacklistPK pk) {
        return getSession().load(Blacklist.class, pk);
    }

    @Override
    public Blacklist read(Class<Blacklist> blacklistClass, BigInteger id) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Override
    public void update(Blacklist object) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Override
    public BigInteger create(Blacklist object) {
        throw new RuntimeException(Error.METHOD_NOT_SUPPORTED);
    }

    @Override
    public BlacklistPK save(Blacklist object) {
        return (BlacklistPK) getSession().save(object);
    }
}
