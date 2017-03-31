package com.kindhope.service;

import com.kindhope.entity.User;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface UserService extends GenericService<User> {
    User findByEmail(String email);

}
