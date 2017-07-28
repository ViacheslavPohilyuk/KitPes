package org.kitpes.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


/**
 * Created by mac on 18.07.17.
 */
@PropertySource("classpath:cloudinary_url.properties")
public class CloudinaryImageHandler implements ImageHandler {
    @Autowired
    private Environment env;

    private Uploader uploader;

    public CloudinaryImageHandler() {
        this.uploader = new Cloudinary(env.getProperty("jdbc.url")).uploader();
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
