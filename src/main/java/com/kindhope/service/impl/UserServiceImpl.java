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
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
