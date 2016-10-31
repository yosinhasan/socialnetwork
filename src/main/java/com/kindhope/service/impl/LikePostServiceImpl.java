package com.kindhope.service.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePostEntity;
import com.kindhope.service.LikePostService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class LikePostServiceImpl implements LikePostService {
    private LikePostDAO likePostDAO;

    public LikePostServiceImpl(LikePostDAO likePostDAO) {
        this.likePostDAO = likePostDAO;
    }
    @Override
    public LikePostEntity read(BigInteger id) {
        return likePostDAO.read(LikePostEntity.class, id);
    }

    @Override
    public Boolean create(LikePostEntity object) {
        return likePostDAO.create(object);
    }

    @Override
    public Boolean update(LikePostEntity object) {
        return likePostDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return likePostDAO.delete(object);
    }

    @Override
    public List<LikePostEntity> readAll() {
        return likePostDAO.readAll();
    }
}
