package com.kindhope.service;

import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPhoto;
import com.kindhope.entity.CommentPhotoPK;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface CommentPhotoService extends GenericPKService<CommentPhoto, CommentPhotoPK>, GenericService<CommentPhoto> {
    List<Comment> findComments(BigInteger photoId);

}
