package com.kindhope.dao.impl;

import com.kindhope.dao.CommentDAO;
import com.kindhope.entity.CommentsEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateCommentDAO extends AbstractHibernateDAO<CommentsEntity> implements CommentDAO {

    @Transactional
    @Override
    public List<CommentsEntity> readAll() {
        return getSession().createQuery("select u from CommentsEntity u", CommentsEntity.class).getResultList();
    }

}
