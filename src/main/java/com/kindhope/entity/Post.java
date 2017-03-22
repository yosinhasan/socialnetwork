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
@Table(name = "post", schema = "kindhope", catalog = "")
public class Post {
    private BigInteger id;
    private BigInteger userId;
    private String post;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
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
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

        Post post1 = (Post) o;

        if (id != null ? !id.equals(post1.id) : post1.id != null) return false;
        if (userId != null ? !userId.equals(post1.userId) : post1.userId != null) return false;
        if (post != null ? !post.equals(post1.post) : post1.post != null) return false;
        if (createdAt != null ? !createdAt.equals(post1.createdAt) : post1.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(post1.updatedAt) : post1.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(post1.deletedAt) : post1.deletedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "postByPostId")
    public Collection<GroupPost> getGroupPostsById() {
        return groupPostsById;
    }

    public void setGroupPostsById(Collection<GroupPost> groupPostsById) {
        this.groupPostsById = groupPostsById;
    }
}
