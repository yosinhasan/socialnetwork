package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import com.kindhope.entity.Photo;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class GalleryPhotoDAOImpl extends AbstractPKDAOImpl<GalleryPhoto, GalleryPhotoPK> implements GalleryPhotoDAO {
    private static final Logger LOG = Logger.getLogger(GalleryPhotoDAOImpl.class);

    @Transactional
    @Override
    public List<GalleryPhoto> readAll() {
        return getSession().createQuery("select gp from GalleryPhoto gp", GalleryPhoto.class).getResultList();
    }

    @Transactional
    @Override
    public GalleryPhoto read(Class<GalleryPhoto> galleryPhotoClass, GalleryPhotoPK galleryPhotoPK) {
        return getSession().get(galleryPhotoClass, galleryPhotoPK);
    }

    @Transactional
    @Override
    public List<Photo> findGalleryPhotos(BigInteger galleryId) {
        LOG.debug("FIND GALLERY PHOTOS BY ID START");
        LOG.debug("GALLERY ID" + galleryId);
        Query<Photo> query = getSession().createQuery("select new com.kindhope.entity.Photo(p.id, p.userId, p.name) from Photo p where p.id in (select gp.photoId from GalleryPhoto gp where gp.galleryId = :galleryId)", Photo.class);
        query.setParameter("galleryId", galleryId);
        List<Photo> list = query.getResultList();
        LOG.debug("FIND GALLERY PHOTOS BY ID END");
        return list;
    }
}
