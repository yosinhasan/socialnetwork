package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhotosEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateGalleryPhotoDAO extends AbstractHibernateDAO<GalleryPhotosEntity> implements GalleryPhotoDAO {

    @Transactional
    @Override
    public List<GalleryPhotosEntity> readAll() {
        return getSession().createQuery("select gp from GalleryPhotosEntity gp", GalleryPhotosEntity.class).getResultList();
    }

}
