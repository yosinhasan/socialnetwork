package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionRequestDAO;
import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class ConnectionRequestDAOImpl extends AbstractPKDAOImpl<ConnectionRequest, ConnectionRequestPK> implements ConnectionRequestDAO {
    @Transactional
    @Override
    public List<ConnectionRequest> readAll() {
        return getSession().createQuery("select cr from ConnectionRequest cr", ConnectionRequest.class).getResultList();
    }

    @Override
    public ConnectionRequest read(Class<ConnectionRequest> connectionRequestClass, ConnectionRequestPK connectionRequestPK) {
        return getSession().get(connectionRequestClass, connectionRequestPK);
    }
}
