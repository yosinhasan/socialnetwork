package com.kindhope.dao.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.PostsEntity;
import com.kindhope.entity.UsersEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernatePostDAO extends AbstractHibernateDAO<PostsEntity> implements PostDAO {

    @Transactional
    @Override
    public List<PostsEntity> readAll() {
        return getSession().createQuery("select u from PostsEntity u", PostsEntity.class).getResultList();
    }

}
