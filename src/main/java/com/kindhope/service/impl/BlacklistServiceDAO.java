package com.kindhope.service.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.model.BlacklistsModel;
import com.kindhope.service.BlacklistService;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class BlacklistServiceDAO implements BlacklistService {
    private BlacklistDAO blacklistDAO;

    public BlacklistServiceDAO(BlacklistDAO blacklistDAO) {
        this.blacklistDAO = blacklistDAO;
    }

    @Override
    public Boolean create(BlacklistsModel object) {
        return blacklistDAO.create(object);
    }

    @Override
    public BlacklistsModel read(BigInteger id) {
        return blacklistDAO.read(id);
    }

    @Override
    public Boolean update(BlacklistsModel object) {
        return blacklistDAO.update(object);
    }

    @Override
    public Boolean delete(Long id) {
        return blacklistDAO.delete(id);
    }

    @Override
    public BlacklistsModel read(String field, Object value) {
        return blacklistDAO.read(field, value);
    }

    @Override
    public ArrayList<BlacklistsModel> readAll() {
        return blacklistDAO.readAll();
    }
}
