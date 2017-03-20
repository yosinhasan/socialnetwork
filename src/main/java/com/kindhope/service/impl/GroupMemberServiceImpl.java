package com.kindhope.service.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.entity.GroupMember;
import com.kindhope.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class GroupMemberServiceImpl implements GroupMemberService {
    @Autowired
    private GroupMemberDAO groupMemberDAO;

    @Override
    public GroupMember read(BigInteger id) {
        return groupMemberDAO.read(GroupMember.class, id);
    }

    @Override
    public BigInteger create(GroupMember object) {
        return groupMemberDAO.create(object);
    }

    @Override
    public void update(GroupMember object) {
        groupMemberDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        groupMemberDAO.delete(object);
    }

    @Override
    public List<GroupMember> readAll() {
        return groupMemberDAO.readAll();
    }
}
