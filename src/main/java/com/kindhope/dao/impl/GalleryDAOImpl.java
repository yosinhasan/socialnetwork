package com.kindhope.dao.impl;

import com.kindhope.dao.GalleryDAO;
import com.kindhope.entity.Gallery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class GalleryDAOImpl extends AbstractDAOImpl<Gallery> implements GalleryDAO {
    @Transactional
    @Override
    public List<Gallery> readAll() {
        return getSession().createQuery("select p from Gallery p", Gallery.class).getResultList();
    }
}
