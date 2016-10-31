package com.kindhope.service.impl;

import com.kindhope.dao.GroupPostDAO;
import com.kindhope.entity.GroupPostEntity;
import com.kindhope.service.GroupPostService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GroupPostServiceImpl implements GroupPostService {
    private GroupPostDAO groupPostDAO;

    public GroupPostServiceImpl(GroupPostDAO groupPostDAO) {
        this.groupPostDAO = groupPostDAO;
    }

    @Override
    public GroupPostEntity read(BigInteger id) {
        return groupPostDAO.read(GroupPostEntity.class, id);
    }

    @Override
    public Boolean create(GroupPostEntity object) {
        return groupPostDAO.create(object);
    }

    @Override
    public Boolean update(GroupPostEntity object) {
        return groupPostDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return groupPostDAO.delete(object);
    }

    @Override
    public List<GroupPostEntity> readAll() {
        return groupPostDAO.readAll();
    }
}
