package com.kindhope.service.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
import com.kindhope.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryDAO galleryDAO;

    @Override
    public Gallery read(BigInteger id) {
        return galleryDAO.read(Gallery.class, id);
    }

    @Override
    public BigInteger create(Gallery object) {
        return galleryDAO.create(object);
    }

    @Override
    public void update(Gallery object) {
        galleryDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        galleryDAO.delete(object);
    }

    @Override
    public List<Gallery> readAll() {
        return galleryDAO.readAll();
    }

    @Override
    public List<Gallery> findAllByUserId(BigInteger userId) {
        return galleryDAO.findAllByUserId(userId);
    }

    @Override
    public Gallery findByGalleryIdAndUserId(BigInteger userId, BigInteger galleryId) {
        return galleryDAO.findByGalleryIdAndUserId(userId, galleryId);
    }
}
