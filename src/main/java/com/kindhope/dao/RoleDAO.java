package com.kindhope.dao;

import com.kindhope.entity.Role;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface RoleDAO extends GenericDAO<Role> {
    Integer createAndReturnIntId(Role object);

    Role read(Integer id);

}
