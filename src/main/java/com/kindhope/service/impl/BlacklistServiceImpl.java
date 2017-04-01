package com.kindhope.service.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import com.kindhope.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Autowired
    private BlacklistDAO blacklistDAO;

    @Override
    public BigInteger create(Blacklist object) {
        return blacklistDAO.create(object);
    }

    public Blacklist read(BigInteger id) {
        return blacklistDAO.read(Blacklist.class, id);
    }

    @Override
    public void update(Blacklist object) {
        blacklistDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        blacklistDAO.delete(object);
    }

    @Override
    public List<Blacklist> readAll() {
        return blacklistDAO.readAll();
    }

    @Override
    public Blacklist read(Class<Blacklist> blacklistClass, BlacklistPK pk) {
        return blacklistDAO.read(blacklistClass, pk);
    }

    @Override
    public BlacklistPK save(Blacklist object) {
        return blacklistDAO.save(object);
    }
}
