package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.dao.GenericDAO;
import com.kindhope.model.BlacklistsModel;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class MysqlBlacklistDAO implements BlacklistDAO {
    @Override
    public Boolean create(BlacklistsModel object) {
        return null;
    }

    @Override
    public BlacklistsModel read(BigInteger id) {
        return null;
    }

    @Override
    public Boolean update(BlacklistsModel object) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public BlacklistsModel read(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<BlacklistsModel> readAll() {
        return null;
    }
}
