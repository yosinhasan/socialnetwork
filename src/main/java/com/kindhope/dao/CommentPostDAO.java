package com.kindhope.dao;

import com.kindhope.entity.Comment;
import com.kindhope.entity.CommentPost;
import com.kindhope.entity.CommentPostPK;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface CommentPostDAO extends GenericDAO<CommentPost>, GenericPKDAO<CommentPost, CommentPostPK> {
    List<Comment> findComments(BigInteger postId);
}
