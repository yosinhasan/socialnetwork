package com.kindhope.service.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.Photo;
import com.kindhope.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDAO photoDAO;

    @Override
    public Photo read(BigInteger id) {
        return photoDAO.read(Photo.class, id);
    }

    @Override
    public BigInteger create(Photo object) {
        return photoDAO.create(object);
    }

    @Override
    public void update(Photo object) {
        photoDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        photoDAO.delete(object);
    }

    @Override
    public List<Photo> readAll() {
        return photoDAO.readAll();
    }
}
