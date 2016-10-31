package com.kindhope.service.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.GroupsEntity;
import com.kindhope.service.GroupService;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Component
public class GroupServiceImpl implements GroupService {
    private GroupDAO groupDAO;

    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }
    @Override
    public GroupsEntity read(BigInteger id) {
        return groupDAO.read(GroupsEntity.class, id);
    }

    @Override
    public Boolean create(GroupsEntity object) {
        return groupDAO.create(object);
    }

    @Override
    public Boolean update(GroupsEntity object) {
        return groupDAO.update(object);
    }

    @Override
    public Boolean delete(Object object) {
        return groupDAO.delete(object);
    }

    @Override
    public List<GroupsEntity> readAll() {
        return groupDAO.readAll();
    }
}
