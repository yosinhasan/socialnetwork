package com.kindhope.dao.impl;

import com.kindhope.dao.GroupMemberDAO;
import com.kindhope.entity.GroupMember;
import com.kindhope.entity.GroupMemberPK;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.NonUniqueObjectException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GroupMemberDAOTest extends AbstractDAOImplTest {

    @Autowired
    GroupMemberDAO dao;

    GroupMember object;

    GroupMemberPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 2);
        pk = getNewPKInstance(1, 2);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/GroupMember.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test(expected = RuntimeException.class)
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test
    public void save() throws Exception {
        assertNotNull(dao.save(object));
    }

    @Test(expected = NonUniqueObjectException.class)
    public void saveDuplicate() throws Exception {
        dao.save(getNewInstance(10, 12));
        dao.save(getNewInstance(10, 12));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(GroupMember.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(GroupMember.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        GroupMember test = dao.read(GroupMember.class, pk);
        test.setUserId(BigInteger.TEN);
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        GroupMember test = dao.read(GroupMember.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        GroupMemberPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(GroupMember.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        GroupMember test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private GroupMember getNewInstance(long id1, long id2) {
        GroupMember test = new GroupMember();
        test.setGroupId(BigInteger.valueOf(id1));
        test.setUserId(BigInteger.valueOf(id2));
        return test;
    }

    private GroupMemberPK getNewPKInstance(long id1, long id2) {
        GroupMemberPK pk = new GroupMemberPK();
        pk.setGroupId(BigInteger.valueOf(id1));
        pk.setUserId(BigInteger.valueOf(id2));
        return pk;
    }

}