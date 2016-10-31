package com.kindhope.dao.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.GroupPostEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateGroupPostDAO extends AbstractHibernateDAO<GroupPostEntity> implements GroupPostDAO {

    @Transactional
    @Override
    public List<GroupPostEntity> readAll() {
        return getSession().createQuery("select u from GroupPostEntity u", GroupPostEntity.class).getResultList();
    }

}
