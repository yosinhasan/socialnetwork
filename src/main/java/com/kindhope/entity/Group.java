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
@Table(name = "usergroup", schema = "kindhope", catalog = "")
public class Group {
    private BigInteger id;
    private BigInteger userId;
    private String title;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Collection<GroupMember> groupMembersById;
    private Collection<GroupPost> groupPostsById;

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
    @Column(name = "user_id")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (userId != null ? !userId.equals(group.userId) : group.userId != null) return false;
        if (title != null ? !title.equals(group.title) : group.title != null) return false;
        if (description != null ? !description.equals(group.description) : group.description != null) return false;
        if (createdAt != null ? !createdAt.equals(group.createdAt) : group.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(group.updatedAt) : group.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(group.deletedAt) : group.deletedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupMember> getGroupMembersById() {
        return groupMembersById;
    }

    public void setGroupMembersById(Collection<GroupMember> groupMembersById) {
        this.groupMembersById = groupMembersById;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupPost> getGroupPostsById() {
        return groupPostsById;
    }

    public void setGroupPostsById(Collection<GroupPost> groupPostsById) {
        this.groupPostsById = groupPostsById;
    }
}
