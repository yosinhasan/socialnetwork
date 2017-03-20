package com.kindhope.service.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.entity.Post;
import com.kindhope.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO postDAO;

    @Override
    public Post read(BigInteger id) {
        return postDAO.read(Post.class, id);
    }

    @Override
    public BigInteger create(Post object) {
        return postDAO.create(object);
    }

    @Override
    public void update(Post object) {
        postDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        postDAO.delete(object);
    }

    @Override
    public List<Post> readAll() {
        return postDAO.readAll();
    }
}
