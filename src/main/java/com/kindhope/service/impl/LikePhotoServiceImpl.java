package com.kindhope.service.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
import com.kindhope.entity.LikePhotoPK;
import com.kindhope.service.LikePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class LikePhotoServiceImpl implements LikePhotoService {
    @Autowired
    private LikePhotoDAO likePhotoDAO;

    @Override
    public LikePhoto read(BigInteger id) {
        return likePhotoDAO.read(LikePhoto.class, id);
    }

    @Override
    public BigInteger create(LikePhoto object) {
        return likePhotoDAO.create(object);
    }

    @Override
    public void delete(Object object) {
        likePhotoDAO.delete(object);
    }

    @Override
    public void update(LikePhoto object) {
        likePhotoDAO.update(object);
    }

    @Override
    public List<LikePhoto> readAll() {
        return likePhotoDAO.readAll();
    }

    @Override
    public LikePhoto read(Class<LikePhoto> likePhotoClass, LikePhotoPK likePhotoPK) {
        return likePhotoDAO.read(likePhotoClass, likePhotoPK);
    }

    @Override
    public LikePhotoPK save(LikePhoto object) {
        return likePhotoDAO.save(object);
    }
}
