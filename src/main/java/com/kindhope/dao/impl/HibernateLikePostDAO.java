package com.kindhope.dao.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePostEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateLikePostDAO extends AbstractHibernateDAO<LikePostEntity> implements LikePostDAO {

    @Transactional
    @Override
    public List<LikePostEntity> readAll() {
        return getSession().createQuery("select u from LikePostEntity u", LikePostEntity.class).getResultList();
    }

}
