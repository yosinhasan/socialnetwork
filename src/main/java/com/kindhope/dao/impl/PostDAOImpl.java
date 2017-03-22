package com.kindhope.dao.impl;

import com.kindhope.dao.PostDAO;
import com.kindhope.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class PostDAOImpl extends AbstractDAOImpl<Post> implements PostDAO {

    @Transactional
    @Override
    public List<Post> readAll() {
        return getSession().createQuery("select u from Post u", Post.class).getResultList();
    }

}
