package org.kitpes.image;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mac on 19.05.17.
 */
@Configuration
public class ImageServiceConfig {
    @Bean
    public ImageHandler cloudSource() {
        return new CloudinaryImageHandler();
    }
}
