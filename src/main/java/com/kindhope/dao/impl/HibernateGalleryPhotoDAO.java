package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryPhotoDAO;
import com.kindhope.entity.GalleryPhoto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateGalleryPhotoDAO extends AbstractHibernateDAO<GalleryPhoto> implements GalleryPhotoDAO {

    @Transactional
    @Override
    public List<GalleryPhoto> readAll() {
        return getSession().createQuery("select gp from GalleryPhoto gp", GalleryPhoto.class).getResultList();
    }

}
