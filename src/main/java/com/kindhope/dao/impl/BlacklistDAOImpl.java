package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class BlacklistDAOImpl extends AbstractPKDAOImpl<Blacklist, BlacklistPK> implements BlacklistDAO {

    @Transactional
    @Override
    public List<Blacklist> readAll() {
        return getSession().createQuery("select b from Blacklist b").getResultList();
    }

    @Transactional
    @Override
    public Blacklist read(Class<Blacklist> blacklistClass, BlacklistPK blacklistPK) {
        return getSession().get(Blacklist.class, blacklistPK);
    }
}
