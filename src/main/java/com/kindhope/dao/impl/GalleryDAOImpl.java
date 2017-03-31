package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
public class GalleryDAOImpl extends AbstractDAOImpl<Gallery> implements GalleryDAO {
    private static final Logger LOG = Logger.getLogger(ConnectionDAOImpl.class);

    @Transactional
    @Override
    public List<Gallery> readAll() {
        return getSession().createQuery("select p from Gallery p", Gallery.class).getResultList();
    }

    @Transactional
    @Override
    public List<Gallery> findAllByUserId(BigInteger userId) {
        LOG.debug("FIND GALLERIES BY  USER ID START");
        LOG.debug("USER ID" + userId);
        Query<Gallery> query = getSession().createQuery("from Gallery g where g.userId = :userId)", Gallery.class);
        query.setParameter("userId", userId);
        List<Gallery> list = query.getResultList();
        LOG.trace("FOUND galleries: " + list);
        LOG.debug("FIND GALLERIES BY  USER ID END");
        return list;
    }

    @Transactional
    @Override
    public Gallery findByGalleryIdAndUserId(BigInteger userId, BigInteger galleryId) {
        LOG.debug("FIND GALLERY BY  USER ID AND GALLERY ID START");
        LOG.debug("USER ID" + userId);
        LOG.debug("GALLERY ID" + galleryId);
        Gallery gallery = null;
        try {
            Query<Gallery> query = getSession().createQuery("from Gallery g where g.userId = :userId AND g.id = :id)", Gallery.class);
            query.setParameter("userId", userId);
            query.setParameter("id", galleryId);
            gallery = query.getSingleResult();
            Hibernate.initialize(gallery.getGalleryPhotosById());
        } catch (Throwable e) {
            LOG.debug("ERROR OCCURED: " + e.getMessage());
        }
        LOG.trace("FOUND GALLERY: " + gallery);
        LOG.debug("FIND GALLERY BY  USER ID AND GALLERY ID END");
        return gallery;
    }
}
