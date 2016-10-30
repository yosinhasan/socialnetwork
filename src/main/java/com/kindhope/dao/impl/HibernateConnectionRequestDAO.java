package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequestsEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateConnectionRequestDAO extends AbstractHibernateDAO<ConnectionRequestsEntity> implements ConnectionRequestDAO {
    @Transactional
    @Override
    public List<ConnectionRequestsEntity> readAll() {
        return getSession().createQuery("select cr from ConnectionRequestsEntity cr", ConnectionRequestsEntity.class).getResultList();
    }
}
