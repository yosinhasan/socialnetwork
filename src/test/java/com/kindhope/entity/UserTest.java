package com.kindhope.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class UserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private User user;
    private BCryptPasswordEncoder encoder;

    @Before
    public void setUp() throws Exception {
        user = new User();
        encoder = new BCryptPasswordEncoder(11);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testId() throws Exception {
        user.setId(BigInteger.TEN);
        assertEquals(BigInteger.TEN, user.getId());
    }

    @Test
    public void testName() throws Exception {
        String expected = "test";
        user.setName(expected);
        assertEquals(expected, user.getName());
    }

    @Test
    public void testEmail() throws Exception {
        String expected = "test@test.com";
        user.setEmail(expected);
        assertEquals(expected, user.getEmail());
    }

    @Test
    public void testPassword() throws Exception {
        String password = "123456";
        String expected = encoder.encode(password);
        user.setPassword(password);
        assertTrue(encoder.matches(user.getPassword(), expected));
    }

    @Test
    public void testRememberToken() throws Exception {
        String expected = "hxdadvbnf234df.#*%adf7&^@fsq1%210dsfxzmarwer";
        user.setRememberToken(expected);
        assertEquals(expected, user.getRememberToken());
    }

    @Test
    public void testProfilePhotoId() throws Exception {
        user.setProfilePhotoId(BigInteger.ONE);
        assertEquals(BigInteger.ONE, user.getProfilePhotoId());
    }

    @Test
    public void testBlockedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        user.setBlockedAt(expected);
        assertEquals(expected, user.getBlockedAt());
    }

    @Test
    public void testDeletedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        user.setDeletedAt(expected);
        assertEquals(expected, user.getDeletedAt());
    }

    @Test
    public void testCreatedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        user.setCreatedAt(expected);
        assertEquals(expected, user.getCreatedAt());
    }

    @Test
    public void testUpdatedAt() throws Exception {
        Timestamp expected = Timestamp.from(Instant.now());
        user.setUpdatedAt(expected);
        assertEquals(expected, user.getUpdatedAt());
    }

    @Test
    public void testPasswordConfirm() throws Exception {
        user.setPassword("123456");
        user.setPasswordConfirm("123456");
        assertEquals(user.getPassword(), user.getPasswordConfirm());
    }

    @Test
    public void equals() throws Exception {
        User testUser = new User();
        assertTrue(user.equals(testUser));
    }

    @Test
    public void testGroupMembersById() throws Exception {
        ArrayList<GroupMember> expected = new ArrayList<>();
        user.setGroupMembersById(expected);
        assertEquals(expected, user.getGroupMembersById());
    }

    @Test
    public void testBlacklistsById() throws Exception {
        ArrayList<Blacklist> expected = new ArrayList<>();
        user.setBlacklistsById(expected);
        assertEquals(expected, user.getBlacklistsById());
    }

    @Test
    public void testBlacklistsByBlockedUserId() throws Exception {
        ArrayList<Blacklist> expected = new ArrayList<>();
        user.setBlacklistsByBlockedUserId(expected);
        assertEquals(expected, user.getBlacklistsByBlockedUserId());
    }

    @Test
    public void tsetCommentsById() throws Exception {
        ArrayList<Comment> expected = new ArrayList<>();
        user.setCommentsById(expected);
        assertEquals(expected, user.getCommentsById());
    }

    @Test
    public void testConnectionsById() throws Exception {
        ArrayList<Connection> expected = new ArrayList<>();
        user.setConnectionsById(expected);
        assertEquals(expected, user.getConnectionsById());
    }

    @Test
    public void testConnectionsByFriendId() throws Exception {
        ArrayList<Connection> expected = new ArrayList<>();
        user.setConnectionsByFriendId(expected);
        assertEquals(expected, user.getConnectionsByFriendId());
    }

    @Test
    public void testConnectionRequestsById() throws Exception {
        ArrayList<ConnectionRequest> expected = new ArrayList<>();
        user.setConnectionRequestsById(expected);
        assertEquals(expected, user.getConnectionRequestsById());
    }

    @Test
    public void testConnectionRequestsById_0() throws Exception {
        ArrayList<ConnectionRequest> expected = new ArrayList<>();
        user.setConnectionRequestsById_0(expected);
        assertEquals(expected, user.getConnectionRequestsById_0());
    }

    @Test
    public void testGalleriesById() throws Exception {
        ArrayList<Gallery> expected = new ArrayList<>();
        user.setGalleriesById(expected);
        assertEquals(expected, user.getGalleriesById());
    }

    @Test
    public void testPhotosById() throws Exception {
        ArrayList<Photo> expected = new ArrayList<>();
        user.setPhotosById(expected);
        assertEquals(expected, user.getPhotosById());
    }

    @Test
    public void testPhotoByProfilePhotoId() throws Exception {
        Photo expected = new Photo();
        user.setPhotoByProfilePhotoId(expected);
        assertEquals(expected, user.getPhotoByProfilePhotoId());
    }

    @Test
    public void testUserRolesById() throws Exception {
        ArrayList<UserRole> expected = new ArrayList<>();
        user.setUserRolesById(expected);
        assertEquals(expected, user.getUserRolesById());
    }
}