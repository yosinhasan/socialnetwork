package com.kindhope.dao.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class GroupDAOImpl extends AbstractDAOImpl<Group> implements GroupDAO {

    @Transactional
    @Override
    public List<Group> readAll() {
        return getSession().createQuery("select u from Group u", Group.class).getResultList();
    }

}
