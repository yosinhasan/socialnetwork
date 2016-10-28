package com.kindhope.service.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.model.PhotosModel;
import com.kindhope.service.PhotoService;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class PhotoServiceDAO implements PhotoService {
    private PhotoDAO photoDAO;

    public PhotoServiceDAO(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

    @Override
    public Boolean create(PhotosModel object) {
        return photoDAO.create(object);
    }

    @Override
    public PhotosModel read(BigInteger id) {
        return photoDAO.read(id);
    }

    @Override
    public Boolean update(PhotosModel object) {
        return photoDAO.update(object);
    }

    @Override
    public Boolean delete(Long id) {
        return photoDAO.delete(id);
    }

    @Override
    public PhotosModel read(String field, Object value) {
        return photoDAO.read(field, value);
    }

    @Override
    public ArrayList<PhotosModel> readAll() {
        return photoDAO.readAll();
    }
}
