package com.kindhope.dao.impl;

import com.kindhope.dao.CommentDAO;
import com.kindhope.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class CommentDAOImpl extends AbstractDAOImpl<Comment> implements CommentDAO {

    @Transactional
    @Override
    public List<Comment> readAll() {
        return getSession().createQuery("select u from Comment u", Comment.class).getResultList();
    }

}
