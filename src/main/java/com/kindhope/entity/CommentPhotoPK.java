package com.kindhope.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public class CommentPhotoPK implements Serializable {
    private BigInteger commentId;
    private BigInteger photoId;

    @Column(name = "comment_id")
    @Id
    public BigInteger getCommentId() {
        return commentId;
    }

    public void setCommentId(BigInteger commentId) {
        this.commentId = commentId;
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

        CommentPhotoPK that = (CommentPhotoPK) o;

        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;
        if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        return result;
    }
}
