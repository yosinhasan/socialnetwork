package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
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
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {
    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

    @Transactional
    @Override
    public List<User> readAll() {
        return getSession().createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        LOG.debug("FIND BY EMAIL START");
        Query<User> query = getSession().createQuery("from User u left join fetch u.blacklistsById where u.email = :userEmail", User.class);
        query.setParameter("userEmail", email);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Throwable e) {

        }
        LOG.debug("FIND BY EMAIL END");
        return user;
    }

    @Override
    public List<User> findBlacklistUsersByUserId(BigInteger userId) {
        LOG.debug("FIND BLACKLIST USERS BY USER ID START");
        LOG.trace("USER ID: " + userId);
        Query<User> query = getSession().createQuery("select u.id, u.name from User u " +
                        "where u.id in (select b.blockedUserId from Blacklist b where b.userId = :userId)",
                User.class);
        query.setParameter("userId", userId);
        LOG.debug("FIND BLACKLIST USERS BY USER ID END");
        return query.getResultList();
    }
}
