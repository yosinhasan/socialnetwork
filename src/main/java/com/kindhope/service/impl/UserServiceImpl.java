package com.kindhope.service.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.User;
import com.kindhope.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    //    @Autowired
//    private RoleDAO roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User read(BigInteger id) {
        return userDAO.read(User.class, id);
    }

    @Override
    public BigInteger create(User object) {
        // need to add default role id
        object.setPassword(bCryptPasswordEncoder.encode(object.getPassword()));
        return userDAO.create(object);
    }

    @Override
    public void update(User object) {
        userDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        userDAO.delete(object);
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Override
    public User findUserWithUserRoles(BigInteger userId) {
        return userDAO.findUserWithUserRoles(userId);
    }

    @Override
    public User findUserWithPhotos(BigInteger userId) {
        return userDAO.findUserWithPhotos(userId);
    }

    @Override
    public User findUserWithGallery(BigInteger userId) {
        return userDAO.findUserWithGallery(userId);
    }

    @Override
    public User findUserWithConnectionsRequests(BigInteger userId) {
        return userDAO.findUserWithConnectionsRequests(userId);
    }

    @Override
    public User findUserWithConnectionsByFriendId(BigInteger friendId) {
        return userDAO.findUserWithConnectionsByFriendId(friendId);
    }

    @Override
    public User findUserWithConnections(BigInteger userId) {
        return userDAO.findUserWithConnections(userId);
    }

    @Override
    public User findUserWithComments(BigInteger userId) {
        return userDAO.findUserWithComments(userId);
    }

    @Override
    public User findUserWithBlacklistUsersByBlockedUserId(BigInteger userId) {
        return userDAO.findUserWithBlacklistUsersByBlockedUserId(userId);
    }

    @Override
    public User findUserWithGroupMember(BigInteger userId) {
        return userDAO.findUserWithGroupMember(userId);
    }

    @Override
    public User findUserWithBlacklistUsersByUserId(BigInteger userId) {
        return userDAO.findUserWithBlacklistUsersByUserId(userId);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
