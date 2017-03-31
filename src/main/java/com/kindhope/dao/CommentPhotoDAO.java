package com.kindhope.dao;

import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface CommentPhotoDAO extends GenericDAO<CommentPhoto>, GenericPKDAO<CommentPhoto, CommentPhotoPK> {
    List<Comment> findComments(BigInteger photoId);
}
