package com.kindhope.service.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.entity.GroupPost;
import com.kindhope.entity.GroupPostPK;
import com.kindhope.service.GroupPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class GroupPostServiceImpl implements GroupPostService {
    @Autowired
    private GroupPostDAO groupPostDAO;

    @Override
    public GroupPost read(BigInteger id) {
        return groupPostDAO.read(GroupPost.class, id);
    }

    @Override
    public BigInteger create(GroupPost object) {
        return groupPostDAO.create(object);
    }

    @Override
    public void update(GroupPost object) {
        groupPostDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        groupPostDAO.delete(object);
    }

    @Override
    public List<GroupPost> readAll() {
        return groupPostDAO.readAll();
    }

    @Override
    public GroupPost read(Class<GroupPost> groupPostClass, GroupPostPK groupPostPK) {
        return groupPostDAO.read(groupPostClass, groupPostPK);
    }

    @Override
    public GroupPostPK save(GroupPost object) {
        return groupPostDAO.save(object);
    }
}
