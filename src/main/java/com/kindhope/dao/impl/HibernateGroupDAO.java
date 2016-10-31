package com.kindhope.dao.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.GroupsEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateGroupDAO extends AbstractHibernateDAO<GroupsEntity> implements GroupDAO {

    @Transactional
    @Override
    public List<GroupsEntity> readAll() {
        return getSession().createQuery("select u from GroupsEntity u", GroupsEntity.class).getResultList();
    }

}
