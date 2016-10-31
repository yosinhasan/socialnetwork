package com.kindhope.service.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhotoEntity;
import com.kindhope.service.LikePhotoService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class LikePhotoServiceImpl implements LikePhotoService {
    private LikePhotoDAO likePhotoDAO;

    public LikePhotoServiceImpl(LikePhotoDAO likePhotoDAO) {
        this.likePhotoDAO = likePhotoDAO;
    }

    @Override
    public LikePhotoEntity read(BigInteger id) {
        return likePhotoDAO.read(LikePhotoEntity.class, id);
    }

    @Override
    public Boolean create(LikePhotoEntity object) {
        return likePhotoDAO.create(object);
    }

    @Override
    public Boolean update(LikePhotoEntity object) {
        return likePhotoDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return likePhotoDAO.delete(object);
    }

    @Override
    public List<LikePhotoEntity> readAll() {
        return likePhotoDAO.readAll();
    }
}
