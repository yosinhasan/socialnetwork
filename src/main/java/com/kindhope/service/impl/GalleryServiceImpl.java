package com.kindhope.service.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.GalleriesEntity;
import com.kindhope.service.GalleryService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class GalleryServiceImpl implements GalleryService {
    private GalleryDAO galleryDAO;

    public GalleryServiceImpl(GalleryDAO galleryDAO) {
        this.galleryDAO = galleryDAO;
    }

    @Override
    public GalleriesEntity read(BigInteger id) {
        return galleryDAO.read(GalleriesEntity.class, id);
    }

    @Override
    public Boolean create(GalleriesEntity object) {
        return galleryDAO.create(object);
    }

    @Override
    public Boolean update(GalleriesEntity object) {
        return galleryDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return galleryDAO.delete(object);
    }

    @Override
    public List<GalleriesEntity> readAll() {
        return galleryDAO.readAll();
    }

}
