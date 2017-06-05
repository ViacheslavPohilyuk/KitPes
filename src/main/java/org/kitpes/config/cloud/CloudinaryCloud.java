package org.kitpes.config.cloud;

import com.cloudinary.Cloudinary;

/**
 * Created by mac on 27.05.17.
 */
public class CloudinaryCloud implements CloudService {
    private Cloudinary cloudinary;

    CloudinaryCloud() {
        String url = "cloudinary://428594225923247:3Nc1lIwCQo9wU-EpePaPqrBHAT0@hyn3znmgk";
        cloudinary = new Cloudinary(url);
    }

    public Cloudinary getConnection() {
        return cloudinary;
    }
}
