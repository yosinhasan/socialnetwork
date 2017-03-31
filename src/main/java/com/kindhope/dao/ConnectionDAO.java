package com.kindhope.dao;

import com.kindhope.entity.Connection;
import com.kindhope.entity.ConnectionPK;
import com.kindhope.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface ConnectionDAO extends GenericDAO<Connection>, GenericPKDAO<Connection, ConnectionPK> {
    List<User> findConnections(BigInteger userId);
}
