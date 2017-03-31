package com.kindhope.dao.impl;

import com.kindhope.dao.LikePhotoDAO;
import com.kindhope.entity.LikePhoto;
import com.kindhope.entity.LikePhotoPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class LikePhotoDAOImpl extends AbstractPKDAOImpl<LikePhoto, LikePhotoPK> implements LikePhotoDAO {

    @Transactional
    @Override
    public List<LikePhoto> readAll() {
        return getSession().createQuery("select u from LikePhoto u", LikePhoto.class).getResultList();
    }

    @Transactional
    @Override
    public LikePhoto read(Class<LikePhoto> likePhotoClass, LikePhotoPK likePhotoPK) {
        return getSession().get(likePhotoClass, likePhotoPK);
    }
}
