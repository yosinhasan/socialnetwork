package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import com.kindhope.web.exception.DAOException;
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
        Query<User> query = getSession().createQuery("from User u where u.email = :userEmail", User.class);
        query.setParameter("userEmail", email);
        return query.uniqueResult();
    }

    @Transactional
    @Override
    public User findUserWithBlacklistUsersByUserId(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getBlacklistsById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithGroupMember(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getGroupMembersById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithBlacklistUsersByBlockedUserId(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getBlacklistsByBlockedUserId());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithComments(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getCommentsById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnections(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getConnectionsById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnectionsByFriendId(BigInteger friendId) {
        User user = null;
        try {
            user = this.read(User.class, friendId);
            Hibernate.initialize(user.getConnectionsByFriendId());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithConnectionsRequests(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getConnectionRequestsById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithGallery(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getGalleriesById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithPhotos(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getPhotosById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Transactional
    @Override
    public User findUserWithUserRoles(BigInteger userId) {
        User user = null;
        try {
            user = this.read(User.class, userId);
            Hibernate.initialize(user.getUserRolesById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }
}
