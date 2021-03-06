package com.kindhope.dao.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.entity.GroupMember;
import com.kindhope.entity.GroupMemberPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class GroupMemberDAOImpl extends AbstractPKDAOImpl<GroupMember, GroupMemberPK> implements GroupMemberDAO {

    @Transactional
    @Override
    public List<GroupMember> readAll() {
        return getSession().createQuery("select u from GroupMember u", GroupMember.class).getResultList();
    }

    @Transactional
    @Override
    public GroupMember read(Class<GroupMember> groupMemberClass, GroupMemberPK groupMemberPK) {
        return getSession().get(groupMemberClass, groupMemberPK);
    }
}
