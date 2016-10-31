package com.kindhope.service.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.CommentPhotoEntity;
import com.kindhope.service.CommentPhotoService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class CommentPhotoServiceImpl implements CommentPhotoService {
    private CommentPhotoDAO commentPhotoDAO;

    public CommentPhotoServiceImpl(CommentPhotoDAO commentPhotoDAO) {
        this.commentPhotoDAO = commentPhotoDAO;
    }
    @Override
    public CommentPhotoEntity read(BigInteger id) {
        return commentPhotoDAO.read(CommentPhotoEntity.class, id);
    }

    @Override
    public Boolean create(CommentPhotoEntity object) {
        return commentPhotoDAO.create(object);
    }

    @Override
    public Boolean update(CommentPhotoEntity object) {
        return commentPhotoDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return commentPhotoDAO.delete(object);
    }

    @Override
    public List<CommentPhotoEntity> readAll() {
        return commentPhotoDAO.readAll();
    }

}
