package com.kindhope.dao.impl;

import com.kindhope.dao.MessageDAO;
import com.kindhope.entity.Message;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class HibernateMessageDAO extends AbstractHibernateDAO<Message> implements MessageDAO {

    @Transactional
    @Override
    public List<Message> readAll() {
        return getSession().createQuery("select u from Message u", Message.class).getResultList();
    }

}
