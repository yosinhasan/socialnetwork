package com.kindhope.service.impl;

import com.kindhope.dao.GroupDAO;
import com.kindhope.entity.Group;
import com.kindhope.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDAO groupDAO;

    @Override
    public Group read(BigInteger id) {
        return groupDAO.read(Group.class, id);
    }

    @Override
    public BigInteger create(Group object) {
        return groupDAO.create(object);
    }

    @Override
    public void update(Group object) {
        groupDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        groupDAO.delete(object);
    }

    @Override
    public List<Group> readAll() {
        return groupDAO.readAll();
    }
}
