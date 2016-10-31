package com.kindhope.dao.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.MessagesEntity;
import com.kindhope.entity.UsersEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateMessageDAO extends AbstractHibernateDAO<MessagesEntity> implements MessageDAO {

    @Transactional
    @Override
    public List<MessagesEntity> readAll() {
        return getSession().createQuery("select u from MessagesEntity u", MessagesEntity.class).getResultList();
    }

}
