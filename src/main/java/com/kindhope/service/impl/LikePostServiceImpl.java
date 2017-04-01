package com.kindhope.service.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePost;
import com.kindhope.entity.LikePostPK;
import com.kindhope.service.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class LikePostServiceImpl implements LikePostService {
    @Autowired
    private LikePostDAO likePostDAO;

    @Override
    public LikePost read(BigInteger id) {
        return likePostDAO.read(LikePost.class, id);
    }

    @Override
    public BigInteger create(LikePost object) {
        return likePostDAO.create(object);
    }

    @Override
    public void update(LikePost object) {
        likePostDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        likePostDAO.delete(object);
    }

    @Override
    public List<LikePost> readAll() {
        return likePostDAO.readAll();
    }

    @Override
    public LikePost read(Class<LikePost> likePostClass, LikePostPK likePostPK) {
        return likePostDAO.read(likePostClass, likePostPK);
    }

    @Override
    public LikePostPK save(LikePost object) {
        return likePostDAO.save(object);
    }
}
