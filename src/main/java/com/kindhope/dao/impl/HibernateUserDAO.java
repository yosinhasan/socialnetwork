package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateUserDAO extends AbstractHibernateDAO<User> implements UserDAO {
    private static final Logger LOG = Logger.getLogger(HibernateUserDAO.class);

    @Transactional
    @Override
    public List<User> readAll() {
        return getSession().createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        LOG.debug("FIND BY EMAIL START");
        Query<User> query = getSession().createQuery("from User u where u.email = :userEmail", User.class);
        query.setParameter("userEmail", email);
        LOG.debug("FIND BY EMAIL END");
        return query.uniqueResult();
    }
}
