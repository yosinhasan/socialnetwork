package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.CommentPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateCommentPostDAO extends AbstractHibernateDAO<CommentPost> implements CommentPostDAO {

    @Transactional
    @Override
    public List<CommentPost> readAll() {
        return getSession().createQuery("select u from CommentPost u", CommentPost.class).getResultList();
    }

}
