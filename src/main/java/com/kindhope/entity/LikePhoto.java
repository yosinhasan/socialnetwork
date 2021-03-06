package com.kindhope.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "like_photo", schema = "kindhope", catalog = "")
@IdClass(LikePhotoPK.class)
public class LikePhoto {
    private BigInteger photoId;
    private BigInteger userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @Id
    @Column(name = "photo_id")
    public BigInteger getPhotoId() {
        return photoId;
    }

    public void setPhotoId(BigInteger photoId) {
        this.photoId = photoId;
    }

    @Id
    @Column(name = "user_id")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
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

        LikePhoto likePhoto = (LikePhoto) o;

        if (photoId != null ? !photoId.equals(likePhoto.photoId) : likePhoto.photoId != null) return false;
        if (userId != null ? !userId.equals(likePhoto.userId) : likePhoto.userId != null) return false;
        if (createdAt != null ? !createdAt.equals(likePhoto.createdAt) : likePhoto.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(likePhoto.updatedAt) : likePhoto.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(likePhoto.deletedAt) : likePhoto.deletedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photoId != null ? photoId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }
}
