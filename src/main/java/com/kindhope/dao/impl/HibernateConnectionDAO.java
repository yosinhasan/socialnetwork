package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.ConnectionsEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateConnectionDAO extends AbstractHibernateDAO<ConnectionsEntity> implements ConnectionDAO {
    @Transactional
    @Override
    public List<ConnectionsEntity> readAll() {
        return getSession().createQuery("select c from ConnectionsEntity c").getResultList();
    }
}
