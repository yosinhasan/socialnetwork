package com.kindhope.service;

import com.kindhope.entity.GalleryPhoto;
import com.kindhope.entity.GalleryPhotoPK;
import com.kindhope.entity.Photo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface GalleryPhotoService extends GenericPKService<GalleryPhoto, GalleryPhotoPK>, GenericService<GalleryPhoto> {
    List<Photo> findGalleryPhotos(BigInteger galleryId);

}
