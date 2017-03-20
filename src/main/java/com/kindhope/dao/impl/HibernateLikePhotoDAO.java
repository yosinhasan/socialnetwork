package com.kindhope.dao.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateLikePhotoDAO extends AbstractHibernateDAO<LikePhoto> implements LikePhotoDAO {

    @Transactional
    @Override
    public List<LikePhoto> readAll() {
        return getSession().createQuery("select u from LikePhoto u", LikePhoto.class).getResultList();
    }

}
