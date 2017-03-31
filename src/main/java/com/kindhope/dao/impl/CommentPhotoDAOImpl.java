package com.kindhope.dao.impl;

import com.kindhope.dao.CommentPhotoDAO;
import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class CommentPhotoDAOImpl extends AbstractPKDAOImpl<CommentPhoto, CommentPhotoPK> implements CommentPhotoDAO {
    private static final Logger LOG = Logger.getLogger(CommentPhotoDAOImpl.class);

    @Transactional
    @Override
    public List<CommentPhoto> readAll() {
        return getSession().createQuery("select u from CommentPhoto u", CommentPhoto.class).getResultList();
    }

    @Transactional
    @Override
    public CommentPhoto read(Class<CommentPhoto> commentPhotoClass, CommentPhotoPK commentPhotoPK) {
        return getSession().get(commentPhotoClass, commentPhotoPK);
    }

    @Transactional
    @Override
    public List<Comment> findComments(BigInteger photoId) {
        LOG.debug("FIND COMMENTS BY PHOTO ID START");
        LOG.debug("PHOTO ID" + photoId);
        Query<Comment> query = getSession().createQuery("from Comment c where c.id in (select cp.commentId from CommentPhoto cp where cp.photoId = :photoId)", Comment.class);
        query.setParameter("photoId", photoId);
        List<Comment> list = query.getResultList();
        LOG.trace("FOUND RESULT: " + list);
        LOG.debug("FIND COMMENTS BY PHOTO ID END");
        return list;
    }
}
