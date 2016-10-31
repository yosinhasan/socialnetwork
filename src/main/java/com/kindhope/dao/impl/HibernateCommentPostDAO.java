package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.UsersEntity;
import com.kindhope.entity.CommentPostEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateCommentPostDAO extends AbstractHibernateDAO<CommentPostEntity> implements CommentPostDAO {

    @Transactional
    @Override
    public List<CommentPostEntity> readAll() {
        return getSession().createQuery("select u from CommentPostEntity u", CommentPostEntity.class).getResultList();
    }

}
