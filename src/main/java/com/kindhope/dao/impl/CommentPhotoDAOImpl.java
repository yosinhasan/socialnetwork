package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class CommentPhotoDAOImpl extends AbstractPKDAOImpl<CommentPhoto, CommentPhotoPK> implements CommentPhotoDAO {

    @Transactional
    @Override
    public List<CommentPhoto> readAll() {
        return getSession().createQuery("select u from CommentPhoto u", CommentPhoto.class).getResultList();
    }

    @Override
    public CommentPhoto read(Class<CommentPhoto> commentPhotoClass, CommentPhotoPK commentPhotoPK) {
        return getSession().get(commentPhotoClass, commentPhotoPK);
    }
}
