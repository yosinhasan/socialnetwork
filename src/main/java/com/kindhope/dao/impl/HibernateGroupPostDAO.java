package com.kindhope.dao.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.entity.GroupPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateGroupPostDAO extends AbstractHibernateDAO<GroupPost> implements GroupPostDAO {

    @Transactional
    @Override
    public List<GroupPost> readAll() {
        return getSession().createQuery("select u from GroupPost u", GroupPost.class).getResultList();
    }

}
