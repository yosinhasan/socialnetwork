package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {
    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

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

    @Transactional
    @Override
    public User findUserWithBlacklistUsersByUserId(BigInteger userId) {
        LOG.debug("FIND BLACKLIST USERS BY USER ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getBlacklistsById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND BLACKLIST USERS BY USER ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithGroupMember(BigInteger userId) {
        LOG.debug("FIND USER  GROUP MEMBERSHIP BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getGroupMembersById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER  GROUP MEMBERSHIP BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithBlacklistUsersByBlockedUserId(BigInteger userId) {
        LOG.debug("FIND USER  BLACKLIST USERS BY BLOCKED ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getBlacklistsByBlockedUserId());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER  BLACKLIST USERS BY BLOCKED ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithComments(BigInteger userId) {
        LOG.debug("FIND USER  COMMMENTS BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getCommentsById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER  COMMMENTS BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnections(BigInteger userId) {
        LOG.debug("FIND USER CONNECTIONS BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getConnectionsById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER CONNECTIONS BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnectionsByFriendId(BigInteger friendId) {
        LOG.debug("FIND USER CONNECTIONS BY FRIEND ID START");
        LOG.trace("FRIEND ID: " + friendId);
        User user = null;
        try {
            user = this.read(User.class, friendId);
            Hibernate.initialize(user.getConnectionsByFriendId());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER CONNECTIONS BY FRIEND ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnectionsRequests(BigInteger userId) {
        LOG.debug("FIND USER CONNECTIONS REQUEST BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getConnectionRequestsById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER CONNECTIONS REQUEST BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithGallery(BigInteger userId) {
        LOG.debug("FIND USER GALLERY BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getGalleriesById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER GALLERY BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithPhotos(BigInteger userId) {
        LOG.debug("FIND USER PHOTOS BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getPhotosById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER PHOTOS BY ID END");
        return user;
    }

    @Transactional
    @Override
    public User findUserWithUserRoles(BigInteger userId) {
        LOG.debug("FIND USER ROLES BY ID START");
        LOG.trace("USER ID: " + userId);
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getUserRolesById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.debug("FIND USER ROLES BY ID START");
        return user;
    }
}
