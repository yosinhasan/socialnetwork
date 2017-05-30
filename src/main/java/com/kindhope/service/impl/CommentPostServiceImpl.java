package com.kindhope.service.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPost;
import com.kindhope.entity.CommentPostPK;
import com.kindhope.service.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class CommentPostServiceImpl implements CommentPostService {
    @Autowired
    private CommentPostDAO commentPostDAO;

    @Override
    public CommentPost read(BigInteger id) {
        return commentPostDAO.read(CommentPost.class, id);
    }

    @Override
    public BigInteger create(CommentPost object) {
        return commentPostDAO.create(object);
    }

    @Override
    public void update(CommentPost object) {
        commentPostDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        commentPostDAO.delete(object);
    }

    @Override
    public List<CommentPost> readAll() {
        return commentPostDAO.readAll();
    }

    @Override
    public CommentPost read(Class<CommentPost> commentPostClass, CommentPostPK commentPostPK) {
        return commentPostDAO.read(commentPostClass, commentPostPK);
    }

    @Override
    public List<Comment> findComments(BigInteger postId) {
        return commentPostDAO.findComments(postId);
    }

    @Override
    public CommentPostPK save(CommentPost object) {
        return commentPostDAO.save(object);
    }
}
