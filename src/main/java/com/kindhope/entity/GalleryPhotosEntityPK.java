package com.kindhope.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class GalleryPhotosEntityPK implements Serializable {
    private BigInteger galleryId;
    private BigInteger photoId;

    @Column(name = "gallery_id")
    @Id
    public BigInteger getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(BigInteger galleryId) {
        this.galleryId = galleryId;
    }

    @Column(name = "photo_id")
    @Id
    public BigInteger getPhotoId() {
        return photoId;
    }

    public void setPhotoId(BigInteger photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GalleryPhotosEntityPK that = (GalleryPhotosEntityPK) o;

        if (galleryId != null ? !galleryId.equals(that.galleryId) : that.galleryId != null) return false;
        if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = galleryId != null ? galleryId.hashCode() : 0;
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        return result;
    }
}
