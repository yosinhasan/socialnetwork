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
@Table(name = "photo", schema = "kindhope", catalog = "")
public class Photo {
    private BigInteger id;
    private BigInteger userId;
    private String name;
    private Collection<GalleryPhoto> galleryPhotosById;
    private User userByUserId;
    private Collection<User> usersById;

    public Photo() {

    }

    public Photo(BigInteger id, BigInteger userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (id != null ? !id.equals(photo.id) : photo.id != null) return false;
        if (userId != null ? !userId.equals(photo.userId) : photo.userId != null) return false;
        if (name != null ? !name.equals(photo.name) : photo.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "photoByPhotoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<GalleryPhoto> getGalleryPhotosById() {
        return galleryPhotosById;
    }

    public void setGalleryPhotosById(Collection<GalleryPhoto> galleryPhotosById) {
        this.galleryPhotosById = galleryPhotosById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "photoByProfilePhotoId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
