package com.kindhope.dao.impl;

import com.kindhope.dao.DeletedConversationDAO;
import com.kindhope.entity.DeletedConversation;
import com.kindhope.entity.DeletedConversationPK;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.NonUniqueObjectException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class DeletedConversationDAOTest extends AbstractDAOImplTest {

    @Autowired
    DeletedConversationDAO dao;

    DeletedConversation object;

    DeletedConversationPK pk;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getNewInstance(1, 1);
        pk = getNewPKInstance(1, 1);

    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/DeletedConversation.xml"));
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
        dao.save(getNewInstance(1, 10));
        dao.save(getNewInstance(1, 10));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(DeletedConversation.class, pk));
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedReadMethod() {
        dao.read(DeletedConversation.class, BigInteger.ONE);
    }

    @Test(expected = RuntimeException.class)
    public void update() throws Exception {
        DeletedConversation test = dao.read(DeletedConversation.class, pk);
        test.setDeletedAt(Timestamp.from(Instant.now()));
        dao.update(test);
    }

    @Test
    public void delete() throws Exception {
        DeletedConversation test = dao.read(DeletedConversation.class, pk);
        int expected = dao.readAll().size() - 1;
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void readNonExistedItem() throws Exception {
        DeletedConversationPK pkTest = getNewPKInstance(1, 111);
        assertNull(dao.read(DeletedConversation.class, pkTest));
    }

    @Test
    public void deleteNonExistedItem() throws Exception {
        DeletedConversation test = getNewInstance(1, 111);
        int expected = dao.readAll().size();
        dao.delete(test);
        int actual = dao.readAll().size();
        assertEquals(expected, actual);
    }

    private DeletedConversation getNewInstance(long id1, long id2) {
        DeletedConversation test = new DeletedConversation();
        test.setUserId(BigInteger.valueOf(id1));
        test.setConversationId(BigInteger.valueOf(id2));
        return test;
    }

    private DeletedConversationPK getNewPKInstance(long id1, long id2) {
        DeletedConversationPK pk = new DeletedConversationPK();
        pk.setUserId(BigInteger.valueOf(id1));
        pk.setConversationId(BigInteger.valueOf(id2));
        return pk;
    }
}