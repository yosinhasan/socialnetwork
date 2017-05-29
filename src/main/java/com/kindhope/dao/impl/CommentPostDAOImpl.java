package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPost;
import com.kindhope.entity.CommentPostPK;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class CommentPostDAOImpl extends AbstractPKDAOImpl<CommentPost, CommentPostPK> implements CommentPostDAO {
    private static final Logger LOG = Logger.getLogger(CommentPostDAOImpl.class);

    @Transactional
    @Override
    public List<CommentPost> readAll() {
        return getSession().createQuery("select u from CommentPost u", CommentPost.class).getResultList();
    }

    @Transactional
    @Override
    public CommentPost read(Class<CommentPost> commentPostClass, CommentPostPK commentPostPK) {
        return getSession().get(commentPostClass, commentPostPK);
    }

    @Transactional
    @Override
    public List<Comment> findComments(BigInteger postId) {
        Query<Comment> query = getSession().createQuery("from Comment c where c.deletedAt is null and c.id in (select cp.commentId from CommentPost cp where cp.postId = :postId and cp.deletedAt is null)", Comment.class);
        query.setParameter("postId", postId);
        List<Comment> list = query.getResultList();
        return list;
    }
}
