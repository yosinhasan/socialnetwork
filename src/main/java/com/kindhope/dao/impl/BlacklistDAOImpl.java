package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import com.kindhope.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class BlacklistDAOImpl extends AbstractPKDAOImpl<Blacklist, BlacklistPK> implements BlacklistDAO {
    private static final Logger LOG = Logger.getLogger(BlacklistDAOImpl.class);

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

    @Transactional
    @Override
    public List<User> findUsersByUserId(BigInteger userId) {
        LOG.debug("FIND BLACKLISTS BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select b.blockedUserId from Blacklist b where b.userId = :userId)", User.class);
        query.setParameter("userId", userId);
        List<User> blacklists = query.getResultList();
        LOG.debug("FIND BLACKLISTS BY  USER ID END");
        return blacklists;
    }

    @Transactional
    @Override
    public List<User> findUsersByBlockedUserId(BigInteger userId) {
        LOG.debug("FIND BLACKLISTS BY BLOCKED USER ID START");
        LOG.debug("USER ID" + userId);
        Query<User> query = getSession().createQuery("select new com.kindhope.entity.User(u.id, u.name) from User u where u.id in (select b.userId from Blacklist b where b.blockedUserId = :userId)", User.class);
        query.setParameter("userId", userId);
        List<User> blacklists = query.getResultList();
        LOG.debug("FIND BLACKLISTS BY  BLOCKED USER ID END");
        return blacklists;
    }
}
