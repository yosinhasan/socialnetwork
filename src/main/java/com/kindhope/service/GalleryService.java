package com.kindhope.service;

import com.kindhope.entity.Gallery;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface GalleryService extends GenericService<Gallery> {
    List<Gallery> findAllByUserId(BigInteger userId);

    Gallery findByGalleryIdAndUserId(BigInteger userId, BigInteger galleryId);

}
