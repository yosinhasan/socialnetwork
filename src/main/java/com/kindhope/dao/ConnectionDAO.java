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

    List<User> findFollowers(BigInteger userId);

    List<User> findFollowing(BigInteger userId);

    Long countConnections(BigInteger userId);

    Long countFollowers(BigInteger userId);

    Long countFollowings(BigInteger userId);

    void removeConnection(BigInteger userId, BigInteger friendId);

    void restoreConnection(BigInteger userId, BigInteger friendId);

    /*
        List<User> findUnConnectedPeople(BigInteger userId); // wi
        List<User> findAllPeopleWithMarkIfConnectedOrNot(BigInteger userId); //


     */
}
