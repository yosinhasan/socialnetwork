package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
import com.kindhope.web.exception.DAOException;
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
        Query<Gallery> query = getSession().createQuery("from Gallery g where g.userId = :userId)", Gallery.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Gallery findByGalleryIdAndUserId(BigInteger userId, BigInteger galleryId) {
        Gallery gallery = null;
        try {
            Query<Gallery> query = getSession().createQuery("from Gallery g where g.userId = :userId AND g.id = :id)", Gallery.class);
            query.setParameter("userId", userId);
            query.setParameter("id", galleryId);
            gallery = query.getSingleResult();
            Hibernate.initialize(gallery.getGalleryPhotosById());
        } catch (Throwable e) {
            throw new DAOException(e.getMessage(), e);
        }
        return gallery;
    }
}
