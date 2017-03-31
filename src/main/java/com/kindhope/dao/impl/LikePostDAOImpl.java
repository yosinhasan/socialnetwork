package com.kindhope.dao.impl;

import com.kindhope.dao.LikePostDAO;
import com.kindhope.entity.LikePost;
import com.kindhope.entity.LikePostPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class LikePostDAOImpl extends AbstractPKDAOImpl<LikePost, LikePostPK> implements LikePostDAO {

    @Transactional
    @Override
    public List<LikePost> readAll() {
        return getSession().createQuery("select u from LikePost u", LikePost.class).getResultList();
    }

    @Transactional
    @Override
    public LikePost read(Class<LikePost> likePostClass, LikePostPK likePostPK) {
        return getSession().get(likePostClass, likePostPK);
    }
}
