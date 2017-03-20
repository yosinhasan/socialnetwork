package com.kindhope.dao;

import com.kindhope.entity.User;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface UserDAO extends GenericDAO<User> {
    User findByEmail(String email);
}
