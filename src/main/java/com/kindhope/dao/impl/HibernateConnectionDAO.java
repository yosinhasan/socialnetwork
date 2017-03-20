package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateConnectionDAO extends AbstractHibernateDAO<Connection> implements ConnectionDAO {
    @Transactional
    @Override
    public List<Connection> readAll() {
        return getSession().createQuery("select c from Connection c").getResultList();
    }
}
