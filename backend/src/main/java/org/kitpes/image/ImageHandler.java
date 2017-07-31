package org.kitpes.image;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by mac on 18.07.17.
 */
public interface ImageHandler {
    String process(MultipartFile image);
}
