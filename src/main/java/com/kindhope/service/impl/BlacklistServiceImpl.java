package com.kindhope.service.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.BlacklistsEntity;
import com.kindhope.service.BlacklistService;
import com.kindhope.service.GenericService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class BlacklistServiceImpl implements BlacklistService {
    private BlacklistDAO blacklistDAO;

    public BlacklistServiceImpl(BlacklistDAO blacklistDAO) {
        this.blacklistDAO = blacklistDAO;
    }

    @Override
    public Boolean create(BlacklistsEntity object) {
        return blacklistDAO.create(object);
    }

    @Override
    public BlacklistsEntity read(BigInteger id) {
        return blacklistDAO.read(BlacklistsEntity.class, id);
    }

    @Override
    public Boolean update(BlacklistsEntity object) {
        return blacklistDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return blacklistDAO.delete(object);
    }

    @Override
    public List<BlacklistsEntity> readAll() {
        return blacklistDAO.readAll();
    }
}
