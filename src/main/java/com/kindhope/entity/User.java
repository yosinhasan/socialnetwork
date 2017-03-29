package com.kindhope.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "user", schema = "kindhope", catalog = "")
public class User {
    private BigInteger id;
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
    private String rememberToken;
    private BigInteger profilePhotoId;
    private Timestamp blockedAt;
    private Timestamp deletedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Collection<GroupMember> groupMembersById;
    private Collection<Blacklist> blacklistsById;
    private Collection<Blacklist> blacklistsByBlockedUserId;
    private Collection<Comment> commentsById;
    private Collection<Connection> connectionsById;
    private Collection<Connection> connectionsByFriendId;
    private Collection<ConnectionRequest> connectionRequestsById;
    private Collection<ConnectionRequest> connectionRequestsById_0;
    private Collection<Gallery> galleriesById;
    private Collection<Photo> photosById;
    private Photo photoByProfilePhotoId;
    private Collection<UserRole> userRolesById;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "remember_token")
    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    @Basic
    @Column(name = "profile_photo_id")
    public BigInteger getProfilePhotoId() {
        return profilePhotoId;
    }

    public void setProfilePhotoId(BigInteger profilePhotoId) {
        this.profilePhotoId = profilePhotoId;
    }

    @Basic
    @Column(name = "blocked_at")
    public Timestamp getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Timestamp blockedAt) {
        this.blockedAt = blockedAt;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (rememberToken != null ? !rememberToken.equals(user.rememberToken) : user.rememberToken != null)
            return false;
        if (profilePhotoId != null ? !profilePhotoId.equals(user.profilePhotoId) : user.profilePhotoId != null)
            return false;
        if (blockedAt != null ? !blockedAt.equals(user.blockedAt) : user.blockedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(user.deletedAt) : user.deletedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(user.updatedAt) : user.updatedAt != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rememberToken != null ? rememberToken.hashCode() : 0);
        result = 31 * result + (profilePhotoId != null ? profilePhotoId.hashCode() : 0);
        result = 31 * result + (blockedAt != null ? blockedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<GroupMember> getGroupMembersById() {
        return groupMembersById;
    }

    public void setGroupMembersById(Collection<GroupMember> groupMembersById) {
        this.groupMembersById = groupMembersById;
    }

    @OneToMany(mappedBy = "userByUserId", fetch = FetchType.LAZY)
    public Collection<Blacklist> getBlacklistsById() {
        return blacklistsById;
    }

    public void setBlacklistsById(Collection<Blacklist> blacklistsById) {
        this.blacklistsById = blacklistsById;
    }

    @OneToMany(mappedBy = "userByBlockedUserId")
    public Collection<Blacklist> getBlacklistsByBlockedUserId() {
        return blacklistsByBlockedUserId;
    }

    public void setBlacklistsByBlockedUserId(Collection<Blacklist> blacklistsByBlockedUserId) {
        this.blacklistsByBlockedUserId = blacklistsByBlockedUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Connection> getConnectionsById() {
        return connectionsById;
    }

    public void setConnectionsById(Collection<Connection> connectionsById) {
        this.connectionsById = connectionsById;
    }

    @OneToMany(mappedBy = "userByFriendId")
    public Collection<Connection> getConnectionsByFriendId() {
        return connectionsByFriendId;
    }

    public void setConnectionsByFriendId(Collection<Connection> connectionsByFriendId) {
        this.connectionsByFriendId = connectionsByFriendId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<ConnectionRequest> getConnectionRequestsById() {
        return connectionRequestsById;
    }

    public void setConnectionRequestsById(Collection<ConnectionRequest> connectionRequestsById) {
        this.connectionRequestsById = connectionRequestsById;
    }

    @OneToMany(mappedBy = "userByRequestId")
    public Collection<ConnectionRequest> getConnectionRequestsById_0() {
        return connectionRequestsById_0;
    }

    public void setConnectionRequestsById_0(Collection<ConnectionRequest> connectionRequestsById_0) {
        this.connectionRequestsById_0 = connectionRequestsById_0;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Gallery> getGalleriesById() {
        return galleriesById;
    }

    public void setGalleriesById(Collection<Gallery> galleriesById) {
        this.galleriesById = galleriesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Photo> getPhotosById() {
        return photosById;
    }

    public void setPhotosById(Collection<Photo> photosById) {
        this.photosById = photosById;
    }

    @ManyToOne
    @JoinColumn(name = "profile_photo_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Photo getPhotoByProfilePhotoId() {
        return photoByProfilePhotoId;
    }

    public void setPhotoByProfilePhotoId(Photo photoByProfilePhotoId) {
        this.photoByProfilePhotoId = photoByProfilePhotoId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserRole> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRole> userRolesById) {
        this.userRolesById = userRolesById;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", rememberToken='" + rememberToken + '\'' +
                ", profilePhotoId=" + profilePhotoId +
                ", blockedAt=" + blockedAt +
                ", deletedAt=" + deletedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", groupMembersById=" + groupMembersById +
                ", blacklistsById=" + blacklistsById +
                ", blacklistsByBlockedUserId=" + blacklistsByBlockedUserId +
                ", commentsById=" + commentsById +
                ", connectionsById=" + connectionsById +
                ", connectionsByFriendId=" + connectionsByFriendId +
                ", connectionRequestsById=" + connectionRequestsById +
                ", connectionRequestsById_0=" + connectionRequestsById_0 +
                ", galleriesById=" + galleriesById +
                ", photosById=" + photosById +
                ", photoByProfilePhotoId=" + photoByProfilePhotoId +
                ", userRolesById=" + userRolesById +
                '}';

    }
}
