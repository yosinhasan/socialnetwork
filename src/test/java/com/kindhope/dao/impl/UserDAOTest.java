package com.kindhope.dao.impl;

import com.kindhope.dao.UserDAO;
import com.kindhope.entity.Blacklist;
import com.kindhope.entity.User;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */

public class UserDAOTest extends AbstractDAOImplTest {

    @Autowired
    UserDAO dao;

    User object;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        object = getObject();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("dataset/User.xml"));
        return dataSet;
    }

    @Test
    public void readAll() throws Exception {
        assertNotNull(dao.readAll());
    }

    @Test
    public void findByEmailReturnsNull() throws Exception {
        assertNull(dao.findByEmail("something@gmail.com"));
    }

    @Test
    public void findByEmail() throws Exception {
        User user = dao.findByEmail("test@tset.dom");
        assertNotNull(user);
    }
    @Test
    public void findUserWithBlacklistUsersByUserId() {
        User user = dao.findUserWithBlacklistUsersByUserId(BigInteger.ONE);
        assertEquals(2, user.getBlacklistsById().size());
    }
    @Test
    public void findUserWithBlacklistUsersByUserIdShouldBeEmpty() {
        User user = dao.findUserWithBlacklistUsersByUserId(BigInteger.valueOf(2));
        assertEquals(0, user.getBlacklistsById().size());
    }
    @Test
    public void findUserWithGroupMember() {
        User user = dao.findUserWithGroupMember(BigInteger.ONE);
        assertEquals(2, user.getGroupMembersById().size());
    }
    @Test
    public void findUserWithGroupMemberShouldBeEmpty() {
        User user = dao.findUserWithGroupMember(BigInteger.valueOf(3));
        assertEquals(0, user.getGroupMembersById().size());
    }
    @Test
    public void findUserWithBlacklistUsersByBlockedUserId() {
        User user = dao.findUserWithBlacklistUsersByBlockedUserId(BigInteger.ONE);
        assertEquals(1, user.getBlacklistsByBlockedUserId().size());
    }
    @Test
    public void findUserWithBlacklistUsersByBlockedUserIdShouldBeEmpty() {
        User user = dao.findUserWithBlacklistUsersByBlockedUserId(BigInteger.valueOf(4));
        assertEquals(0, user.getBlacklistsByBlockedUserId().size());
    }
    @Test
    public void findUserWithComments() {
        User user = dao.findUserWithComments(BigInteger.ONE);
        assertEquals(3, user.getCommentsById().size());
    }
    @Test
    public void findUserWithCommentsShouldBeEmpty() {
        User user = dao.findUserWithComments(BigInteger.valueOf(3));
        assertEquals(0, user.getCommentsById().size());
    }
    @Test
    public void findUserWithConnections() {
        User user = dao.findUserWithConnections(BigInteger.ONE);
        assertEquals(2, user.getConnectionsById().size());
    }
    @Test
    public void findUserWithConnectionsShouldBeEmpty() {
        User user = dao.findUserWithConnections(BigInteger.valueOf(3));
        assertEquals(0, user.getConnectionsById().size());
    }
    @Test
    public void findUserWithConnectionsByFriendId() {
        User user = dao.findUserWithConnectionsByFriendId(BigInteger.ONE);
        assertEquals(0, user.getConnectionsByFriendId().size());
    }
    @Test
    public void findUserWithConnectionsByFriendIdShouldBeEmpty() {
        User user = dao.findUserWithConnectionsByFriendId(BigInteger.valueOf(4));
        assertEquals(0, user.getConnectionsByFriendId().size());
    }

    @Test
    public void findUserWithConnectionsRequests() {
        User user = dao.findUserWithConnectionsRequests(BigInteger.ONE);
        assertEquals(2, user.getConnectionRequestsById().size());
    }
    @Test
    public void findUserWithConnectionsRequestsShouldBeEmpty() {
        User user = dao.findUserWithConnectionsRequests(BigInteger.valueOf(3));
        assertEquals(0, user.getConnectionRequestsById().size());
    }
    @Test
    public void findUserWithGallery() {
        User user = dao.findUserWithGallery(BigInteger.ONE);
        assertEquals(2, user.getGalleriesById().size());
    }
    @Test
    public void findUserWithGalleryShouldBeEmpty() {
        User user = dao.findUserWithGallery(BigInteger.valueOf(3));
        assertEquals(0, user.getGalleriesById().size());
    }
    @Test
    public void findUserWithPhotos() {
        User user = dao.findUserWithPhotos(BigInteger.ONE);
        assertEquals(2, user.getPhotosById().size());
    }
    @Test
    public void findUserWithPhotosShouldBeEmpty() {
        User user = dao.findUserWithPhotos(BigInteger.valueOf(3));
        assertEquals(0, user.getPhotosById().size());
    }
    @Test
    public void findUserWithUserRoles() {
        User user = dao.findUserWithUserRoles(BigInteger.ONE);
        assertEquals(2, user.getUserRolesById().size());
    }
    @Test
    public void findUserWithUserRolesShouldBeEmpty() {
        User user = dao.findUserWithUserRoles(BigInteger.valueOf(3));
        assertEquals(0, user.getUserRolesById().size());
    }

    @Test
    public void create() throws Exception {
        assertNotNull(dao.create(object));
    }

    @Test
    public void read() throws Exception {
        assertNotNull(dao.read(User.class, BigInteger.ONE));
    }

    @Test
    public void readNonExistedItem() throws Exception {
        assertNull(dao.read(User.class, BigInteger.valueOf(999)));
    }

    @Test
    public void update() throws Exception {
        String email = "updated@test.com";
        User test = dao.findByEmail("test@tset.dom");
        test.setEmail(email);
        dao.update(test);
        assertNotNull(dao.findByEmail(email));
    }

    @Test
    public void delete() throws Exception {
        String email = "test3@tset.dom";
        User test = dao.findByEmail(email);
        assertNotNull(test);
        dao.delete(test);
        assertNull(dao.findByEmail(email));
    }

    private User getObject() {
        User test = new User();
        test.setName("Test object");
        test.setEmail("testuser@gmail.com");
        test.setPassword("123456");
        return test;
    }

}