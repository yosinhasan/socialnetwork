package com.kindhope.dao;

import com.kindhope.entity.User;

import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface UserDAO extends GenericDAO<User> {
    User findByEmail(String email);

    User findUserWithBlacklistUsersByUserId(BigInteger userId);

    User findUserWithGroupMember(BigInteger userId);

    User findUserWithBlacklistUsersByBlockedUserId(BigInteger userId);

    User findUserWithComments(BigInteger userId);

    User findUserWithConnections(BigInteger userId);

    User findUserWithConnectionsByFriendId(BigInteger friendId);

    User findUserWithConnectionsRequests(BigInteger userId);

    User findUserWithGallery(BigInteger userId);

    User findUserWithPhotos(BigInteger userId);

    User findUserWithUserRoles(BigInteger userId);
}
