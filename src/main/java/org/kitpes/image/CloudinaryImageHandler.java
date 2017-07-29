package org.kitpes.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


/**
 * Created by mac on 18.07.17.
 */
public class CloudinaryImageHandler implements ImageHandler {
    private Uploader uploader;

    public CloudinaryImageHandler(String url) {
        this.uploader = new Cloudinary(url).uploader();
    }

    public String process(MultipartFile image) {
        String imageUrl = null;
        try {
            Map uploadResult = uploader.upload(image.getBytes(), ObjectUtils.emptyMap());
            imageUrl = (String) uploadResult.get("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrl;
    }
}
