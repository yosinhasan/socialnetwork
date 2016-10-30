package com.kindhope.dao.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.PhotosEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernatePhotoDAO extends AbstractHibernateDAO<PhotosEntity> implements PhotoDAO {

    @Transactional
    @Override
    public List<PhotosEntity> readAll() {
        return getSession().createQuery("select p from PhotosEntity p", PhotosEntity.class).getResultList();
    }

}
