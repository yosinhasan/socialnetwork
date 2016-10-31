package com.kindhope.service.impl;

import com.kindhope.dao.CommentPostDAO;
import com.kindhope.entity.CommentPostEntity;
import com.kindhope.service.CommentPostService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class CommentPostServiceImpl implements CommentPostService {
    private CommentPostDAO commentPostDAO;

    public CommentPostServiceImpl(CommentPostDAO commentPostDAO) {
        this.commentPostDAO = commentPostDAO;
    }
    @Override
    public CommentPostEntity read(BigInteger id) {
        return commentPostDAO.read(CommentPostEntity.class, id);
    }

    @Override
    public Boolean create(CommentPostEntity object) {
        return commentPostDAO.create(object);
    }

    @Override
    public Boolean update(CommentPostEntity object) {
        return commentPostDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return commentPostDAO.delete(object);
    }

    @Override
    public List<CommentPostEntity> readAll() {
        return commentPostDAO.readAll();
    }
}
