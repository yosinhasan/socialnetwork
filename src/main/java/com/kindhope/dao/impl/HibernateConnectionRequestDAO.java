package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateConnectionRequestDAO extends AbstractHibernateDAO<ConnectionRequest> implements ConnectionRequestDAO {
    @Transactional
    @Override
    public List<ConnectionRequest> readAll() {
        return getSession().createQuery("select cr from ConnectionRequest cr", ConnectionRequest.class).getResultList();
    }
}
