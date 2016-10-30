package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.GalleriesEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateGalleryDAO extends AbstractHibernateDAO<GalleriesEntity> implements GalleryDAO {
    @Transactional
    @Override
    public List<GalleriesEntity> readAll() {
        return getSession().createQuery("select p from GalleriesEntity p", GalleriesEntity.class).getResultList();
    }
}
