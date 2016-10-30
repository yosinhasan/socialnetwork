package com.kindhope.service.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhotosEntity;
import com.kindhope.service.GalleryPhotoService;
import com.kindhope.service.GenericService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class GalleryPhotoServiceImpl implements GalleryPhotoService {
    private GalleryPhotoDAO galleryPhotoDAO;

    public GalleryPhotoServiceImpl(GalleryPhotoDAO galleryPhotoDAO) {
        this.galleryPhotoDAO = galleryPhotoDAO;
    }
    @Override
    public GalleryPhotosEntity read(BigInteger id) {
        return galleryPhotoDAO.read(GalleryPhotosEntity.class, id);
    }

    @Override
    public Boolean create(GalleryPhotosEntity object) {
        return galleryPhotoDAO.create(object);
    }

    @Override
    public Boolean update(GalleryPhotosEntity object) {
        return galleryPhotoDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return galleryPhotoDAO.delete(object);
    }

    @Override
    public List<GalleryPhotosEntity> readAll() {
        return galleryPhotoDAO.readAll();
    }
}
