package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class GalleryPhotoDAOImpl extends AbstractPKDAOImpl<GalleryPhoto, GalleryPhotoPK> implements GalleryPhotoDAO {

    @Transactional
    @Override
    public List<GalleryPhoto> readAll() {
        return getSession().createQuery("select gp from GalleryPhoto gp", GalleryPhoto.class).getResultList();
    }

    @Override
    public GalleryPhoto read(Class<GalleryPhoto> galleryPhotoClass, GalleryPhotoPK galleryPhotoPK) {
        return getSession().get(galleryPhotoClass, galleryPhotoPK);
    }
}
