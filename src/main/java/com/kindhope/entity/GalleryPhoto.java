package com.kindhope.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "gallery_photo", schema = "kindhope", catalog = "")
@IdClass(GalleryPhotoPK.class)
public class GalleryPhoto {
    private BigInteger galleryId;
    private BigInteger photoId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Photo photoByPhotoId;
    private Gallery galleryByGalleryId;

    @Id
    @Column(name = "gallery_id")
    public BigInteger getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(BigInteger galleryId) {
        this.galleryId = galleryId;
    }

    @Id
    @Column(name = "photo_id")
    public BigInteger getPhotoId() {
        return photoId;
    }

    public void setPhotoId(BigInteger photoId) {
        this.photoId = photoId;
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

        GalleryPhoto that = (GalleryPhoto) o;

        if (galleryId != null ? !galleryId.equals(that.galleryId) : that.galleryId != null) return false;
        if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(that.deletedAt) : that.deletedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = galleryId != null ? galleryId.hashCode() : 0;
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Photo getPhotoByPhotoId() {
        return photoByPhotoId;
    }

    public void setPhotoByPhotoId(Photo photoByPhotoId) {
        this.photoByPhotoId = photoByPhotoId;
    }

    @ManyToOne
    @JoinColumn(name = "gallery_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Gallery getGalleryByGalleryId() {
        return galleryByGalleryId;
    }

    public void setGalleryByGalleryId(Gallery galleryByGalleryId) {
        this.galleryByGalleryId = galleryByGalleryId;
    }
}
