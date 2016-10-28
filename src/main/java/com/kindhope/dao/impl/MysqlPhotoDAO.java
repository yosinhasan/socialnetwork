package com.kindhope.dao.impl;

import com.kindhope.dao.PhotoDAO;
import com.kindhope.model.PhotosModel;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlPhotoDAO implements PhotoDAO {
    @Override
    public Boolean create(PhotosModel object) {
        return null;
    }

    @Override
    public PhotosModel read(BigInteger id) {
        return null;
    }

    @Override
    public Boolean update(PhotosModel object) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public PhotosModel read(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<PhotosModel> readAll() {
        return null;
    }
}
