package com.kindhope.dao.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.dao.UserDAO;
import com.kindhope.entity.GroupMemberEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class HibernateGroupMemberDAO extends AbstractHibernateDAO<GroupMemberEntity> implements GroupMemberDAO{

    @Transactional
    @Override
    public List<GroupMemberEntity> readAll() {
        return getSession().createQuery("select u from GroupMemberEntity u", GroupMemberEntity.class).getResultList();
    }

}
