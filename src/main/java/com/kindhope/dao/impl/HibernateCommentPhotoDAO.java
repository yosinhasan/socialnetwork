package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.CommentPhoto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateCommentPhotoDAO extends AbstractHibernateDAO<CommentPhoto> implements CommentPhotoDAO {

    @Transactional
    @Override
    public List<CommentPhoto> readAll() {
        return getSession().createQuery("select u from CommentPhoto u", CommentPhoto.class).getResultList();
    }

}
