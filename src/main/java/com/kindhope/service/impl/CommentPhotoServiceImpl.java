package com.kindhope.service.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;
import com.kindhope.service.CommentPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class CommentPhotoServiceImpl implements CommentPhotoService {
    @Autowired
    private CommentPhotoDAO commentPhotoDAO;

    @Override
    public CommentPhoto read(BigInteger id) {
        return commentPhotoDAO.read(CommentPhoto.class, id);
    }

    @Override
    public BigInteger create(CommentPhoto object) {
        return commentPhotoDAO.create(object);
    }

    @Override
    public void update(CommentPhoto object) {
        commentPhotoDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        commentPhotoDAO.delete(object);
    }

    @Override
    public List<CommentPhoto> readAll() {
        return commentPhotoDAO.readAll();
    }

    @Override
    public CommentPhoto read(Class<CommentPhoto> commentPhotoClass, CommentPhotoPK commentPhotoPK) {
        return commentPhotoDAO.read(commentPhotoClass, commentPhotoPK);
    }

    @Override
    public CommentPhotoPK save(CommentPhoto object) {
        return commentPhotoDAO.save(object);
    }

    @Override
    public List<Comment> findComments(BigInteger photoId) {
        return commentPhotoDAO.findComments(photoId);
    }
}
