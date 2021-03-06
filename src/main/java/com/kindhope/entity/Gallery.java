package com.kindhope.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Entity
@Table(name = "gallery", schema = "kindhope", catalog = "")
public class Gallery {
    private BigInteger id;
    private String name;
    private BigInteger userId;
    private User userByUserId;
    private Collection<GalleryPhoto> galleryPhotosById;

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
    @Column(name = "user_id")
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gallery gallery = (Gallery) o;

        if (id != null ? !id.equals(gallery.id) : gallery.id != null) return false;
        if (name != null ? !name.equals(gallery.name) : gallery.name != null) return false;
        if (userId != null ? !userId.equals(gallery.userId) : gallery.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "galleryByGalleryId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<GalleryPhoto> getGalleryPhotosById() {
        return galleryPhotosById;
    }

    public void setGalleryPhotosById(Collection<GalleryPhoto> galleryPhotosById) {
        this.galleryPhotosById = galleryPhotosById;
    }
}
