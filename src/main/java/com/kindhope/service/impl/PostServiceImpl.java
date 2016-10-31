package com.kindhope.service.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.entity.PostsEntity;
import com.kindhope.service.PostService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class PostServiceImpl implements PostService {
    private PostDAO postDAO;

    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public PostsEntity read(BigInteger id) {
        return postDAO.read(PostsEntity.class, id);
    }

    @Override
    public Boolean create(PostsEntity object) {
        return postDAO.create(object);
    }

    @Override
    public Boolean update(PostsEntity object) {
        return postDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return postDAO.delete(object);
    }

    @Override
    public List<PostsEntity> readAll() {
        return postDAO.readAll();
    }
}
