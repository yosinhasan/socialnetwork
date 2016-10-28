package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.dao.GenericDAO;
import com.kindhope.model.GalleriesModel;
import com.kindhope.service.GalleryService;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlGalleryDAO implements GalleryService {
    private GalleryDAO galleryDAO;

    public MysqlGalleryDAO(GalleryDAO galleryDAO) {
        this.galleryDAO = galleryDAO;
    }

    @Override
    public Boolean create(GalleriesModel object) {
        return galleryDAO.create(object);
    }

    @Override
    public GalleriesModel read(BigInteger id) {
        return galleryDAO.read(id);
    }

    @Override
    public Boolean update(GalleriesModel object) {
        return galleryDAO.update(object);
    }

    @Override
    public Boolean delete(Long id) {
        return galleryDAO.delete(id);
    }

    @Override
    public GalleriesModel read(String field, Object value) {
        return galleryDAO.read(field, value);
    }

    @Override
    public ArrayList<GalleriesModel> readAll() {
        return galleryDAO.readAll();
    }
}
