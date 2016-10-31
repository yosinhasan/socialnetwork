package com.kindhope.service.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.entity.GroupMemberEntity;
import com.kindhope.service.GroupMemberService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class GroupMemberServiceImpl implements GroupMemberService {
    private GroupMemberDAO groupMemberDAO;

    public GroupMemberServiceImpl(GroupMemberDAO groupMemberDAO) {
        this.groupMemberDAO = groupMemberDAO;
    }

    @Override
    public GroupMemberEntity read(BigInteger id) {
        return groupMemberDAO.read(GroupMemberEntity.class, id);
    }

    @Override
    public Boolean create(GroupMemberEntity object) {
        return groupMemberDAO.create(object);
    }

    @Override
    public Boolean update(GroupMemberEntity object) {
        return groupMemberDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return groupMemberDAO.delete(object);
    }

    @Override
    public List<GroupMemberEntity> readAll() {
        return groupMemberDAO.readAll();
    }
}
