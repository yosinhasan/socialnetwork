package com.kindhope.service.impl;

import com.kindhope.dao.CommentDAO;
import com.kindhope.entity.Comment;
import com.kindhope.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment read(BigInteger id) {
        return commentDAO.read(Comment.class, id);
    }

    @Override
    public BigInteger create(Comment object) {
        return commentDAO.create(object);
    }

    @Override
    public void update(Comment object) {
        commentDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        commentDAO.delete(object);
    }

    @Override
    public List<Comment> readAll() {
        return commentDAO.readAll();
    }
}
