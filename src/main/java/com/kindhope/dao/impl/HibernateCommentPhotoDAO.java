package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.CommentPhotoEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateCommentPhotoDAO extends AbstractHibernateDAO<CommentPhotoEntity> implements CommentPhotoDAO {

    @Transactional
    @Override
    public List<CommentPhotoEntity> readAll() {
        return getSession().createQuery("select u from CommentPhotoEntity u", CommentPhotoEntity.class).getResultList();
    }

}
