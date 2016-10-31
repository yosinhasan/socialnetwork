package com.kindhope.dao.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhotoEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateLikePhotoDAO extends AbstractHibernateDAO<LikePhotoEntity> implements LikePhotoDAO {

    @Transactional
    @Override
    public List<LikePhotoEntity> readAll() {
        return getSession().createQuery("select u from LikePhotoEntity u", LikePhotoEntity.class).getResultList();
    }

}
