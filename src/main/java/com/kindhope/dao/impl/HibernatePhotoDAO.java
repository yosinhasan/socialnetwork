package com.kindhope.dao.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernatePhotoDAO extends AbstractHibernateDAO<Photo> implements PhotoDAO {

    @Transactional
    @Override
    public List<Photo> readAll() {
        return getSession().createQuery("select p from Photo p", Photo.class).getResultList();
    }

}
