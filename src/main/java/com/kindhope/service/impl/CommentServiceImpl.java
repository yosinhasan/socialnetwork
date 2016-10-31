package com.kindhope.service.impl;

import com.kindhope.dao.CommentDAO;
import com.kindhope.entity.CommentsEntity;
import com.kindhope.service.CommentService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class CommentServiceImpl implements CommentService {
    private CommentDAO commentDAO;

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
    @Override
    public CommentsEntity read(BigInteger id) {
        return commentDAO.read(CommentsEntity.class, id);
    }

    @Override
    public Boolean create(CommentsEntity object) {
        return commentDAO.create(object);
    }

    @Override
    public Boolean update(CommentsEntity object) {
        return commentDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return commentDAO.delete(object);
    }

    @Override
    public List<CommentsEntity> readAll() {
        return commentDAO.readAll();
    }
}
