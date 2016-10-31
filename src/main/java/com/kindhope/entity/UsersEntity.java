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
@Table(name = "users", schema = "kindhope", catalog = "")
public class UsersEntity {
    private BigInteger id;
    private String name;
    private String email;
    private String password;
    private String rememberToken;
    private Timestamp blockedAt;
    private Timestamp deletedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Collection<BlacklistsEntity> blacklistsesById;
    private Collection<BlacklistsEntity> blacklistsesById_0;
    private Collection<ConnectionRequestsEntity> connectionRequestsesById;
    private Collection<ConnectionRequestsEntity> connectionRequestsesById_0;
    private Collection<ConnectionsEntity> connectionsesById;
    private Collection<ConnectionsEntity> connectionsesById_0;
    private Collection<GalleriesEntity> galleriesById;
    private Collection<PhotosEntity> photosesById;
    private Collection<CommentsEntity> commentsesById;
    private Collection<GroupMemberEntity> groupMembersById;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (rememberToken != null ? !rememberToken.equals(that.rememberToken) : that.rememberToken != null)
            return false;
        if (blockedAt != null ? !blockedAt.equals(that.blockedAt) : that.blockedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(that.deletedAt) : that.deletedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rememberToken != null ? rememberToken.hashCode() : 0);
        result = 31 * result + (blockedAt != null ? blockedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<BlacklistsEntity> getBlacklistsesById() {
        return blacklistsesById;
    }

    public void setBlacklistsesById(Collection<BlacklistsEntity> blacklistsesById) {
        this.blacklistsesById = blacklistsesById;
    }

    @OneToMany(mappedBy = "usersByBlockedUserId")
    public Collection<BlacklistsEntity> getBlacklistsesById_0() {
        return blacklistsesById_0;
    }

    public void setBlacklistsesById_0(Collection<BlacklistsEntity> blacklistsesById_0) {
        this.blacklistsesById_0 = blacklistsesById_0;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<ConnectionRequestsEntity> getConnectionRequestsesById() {
        return connectionRequestsesById;
    }

    public void setConnectionRequestsesById(Collection<ConnectionRequestsEntity> connectionRequestsesById) {
        this.connectionRequestsesById = connectionRequestsesById;
    }

    @OneToMany(mappedBy = "usersByRequestId")
    public Collection<ConnectionRequestsEntity> getConnectionRequestsesById_0() {
        return connectionRequestsesById_0;
    }

    public void setConnectionRequestsesById_0(Collection<ConnectionRequestsEntity> connectionRequestsesById_0) {
        this.connectionRequestsesById_0 = connectionRequestsesById_0;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<ConnectionsEntity> getConnectionsesById() {
        return connectionsesById;
    }

    public void setConnectionsesById(Collection<ConnectionsEntity> connectionsesById) {
        this.connectionsesById = connectionsesById;
    }

    @OneToMany(mappedBy = "usersByFriendId")
    public Collection<ConnectionsEntity> getConnectionsesById_0() {
        return connectionsesById_0;
    }

    public void setConnectionsesById_0(Collection<ConnectionsEntity> connectionsesById_0) {
        this.connectionsesById_0 = connectionsesById_0;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<GalleriesEntity> getGalleriesById() {
        return galleriesById;
    }

    public void setGalleriesById(Collection<GalleriesEntity> galleriesById) {
        this.galleriesById = galleriesById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<PhotosEntity> getPhotosesById() {
        return photosesById;
    }

    public void setPhotosesById(Collection<PhotosEntity> photosesById) {
        this.photosesById = photosesById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<CommentsEntity> getCommentsesById() {
        return commentsesById;
    }

    public void setCommentsesById(Collection<CommentsEntity> commentsesById) {
        this.commentsesById = commentsesById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<GroupMemberEntity> getGroupMembersById() {
        return groupMembersById;
    }

    public void setGroupMembersById(Collection<GroupMemberEntity> groupMembersById) {
        this.groupMembersById = groupMembersById;
    }
}
