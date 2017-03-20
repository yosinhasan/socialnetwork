package com.kindhope.service;

import com.kindhope.entity.Role;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface RoleService extends GenericService<Role> {
    Integer save(Role object);

    Role read(Integer id);
}

