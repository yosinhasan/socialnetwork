package com.kindhope.service;

import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPost;
import com.kindhope.entity.CommentPostPK;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface CommentPostService extends GenericPKService<CommentPost, CommentPostPK>, GenericService<CommentPost> {
    List<Comment> findComments(BigInteger postId);

}
