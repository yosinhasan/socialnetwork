package com.kindhope.dao.impl;

import com.kindhope.dao.BlacklistDAO;
import com.kindhope.entity.BlacklistsEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateBlacklistDAO extends AbstractHibernateDAO<BlacklistsEntity> implements BlacklistDAO {
    @Transactional
    @Override
    public List<BlacklistsEntity> readAll() {
        return getSession().createQuery("select b from BlacklistsEntity b").getResultList();
    }
}
