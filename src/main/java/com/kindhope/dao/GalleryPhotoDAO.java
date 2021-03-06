package com.kindhope.dao;

import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import com.kindhope.entity.Photo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface GalleryPhotoDAO extends GenericDAO<GalleryPhoto>, GenericPKDAO<GalleryPhoto, GalleryPhotoPK> {

    List<Photo> findGalleryPhotos(BigInteger galleryId);
}
