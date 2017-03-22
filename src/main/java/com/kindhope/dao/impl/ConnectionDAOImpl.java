package com.kindhope.dao.impl;

import com.kindhope.dao.ConnectionDAO;
import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class ConnectionDAOImpl extends AbstractPKDAOImpl<Connection, ConnectionPK> implements ConnectionDAO {
    @Transactional
    @Override
    public List<Connection> readAll() {
        return getSession().createQuery("select c from Connection c").getResultList();
    }

    @Override
    public Connection read(Class<Connection> connectionClass, ConnectionPK connectionPK) {
        return getSession().get(connectionClass, connectionPK);
    }
}
