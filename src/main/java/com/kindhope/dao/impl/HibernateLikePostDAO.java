package com.kindhope.dao.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateLikePostDAO extends AbstractHibernateDAO<LikePost> implements LikePostDAO {

    @Transactional
    @Override
    public List<LikePost> readAll() {
        return getSession().createQuery("select u from LikePost u", LikePost.class).getResultList();
    }

}
