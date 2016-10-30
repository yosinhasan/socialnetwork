package com.kindhope.service.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.entity.PhotosEntity;
import com.kindhope.service.GenericService;
import com.kindhope.service.PhotoService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class PhotoServiceImpl implements PhotoService {
    private PhotoDAO photoDAO;

    public PhotoServiceImpl(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }
    @Override
    public PhotosEntity read(BigInteger id) {
        return photoDAO.read(PhotosEntity.class, id);
    }

    @Override
    public Boolean create(PhotosEntity object) {
        return photoDAO.create(object);
    }

    @Override
    public Boolean update(PhotosEntity object) {
        return photoDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return photoDAO.delete(object);
    }

    @Override
    public List<PhotosEntity> readAll() {
        return photoDAO.readAll();
    }
}
