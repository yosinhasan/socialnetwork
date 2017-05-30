package com.kindhope.service.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import com.kindhope.entity.Photo;
import com.kindhope.service.GalleryPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class GalleryPhotoServiceImpl implements GalleryPhotoService {
    @Autowired
    private GalleryPhotoDAO galleryPhotoDAO;

    @Override
    public GalleryPhoto read(BigInteger id) {
        return galleryPhotoDAO.read(GalleryPhoto.class, id);
    }

    @Override
    public BigInteger create(GalleryPhoto object) {
        return galleryPhotoDAO.create(object);
    }

    @Override
    public void update(GalleryPhoto object) {
        galleryPhotoDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        galleryPhotoDAO.delete(object);
    }

    @Override
    public List<GalleryPhoto> readAll() {
        return galleryPhotoDAO.readAll();
    }

    @Override
    public GalleryPhoto read(Class<GalleryPhoto> galleryPhotoClass, GalleryPhotoPK galleryPhotoPK) {
        return galleryPhotoDAO.read(galleryPhotoClass, galleryPhotoPK);
    }

    @Override
    public GalleryPhotoPK save(GalleryPhoto object) {
        return galleryPhotoDAO.save(object);
    }

    @Override
    public List<Photo> findGalleryPhotos(BigInteger galleryId) {
        return galleryPhotoDAO.findGalleryPhotos(galleryId);
    }
}
