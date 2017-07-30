package org.kitpes.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by mac on 19.05.17.
 */
@Configuration
@PropertySource("classpath:cloud_service.properties")
public class ImageServiceConfig {
    @Autowired
    private Environment env;

    @Bean
    public ImageHandler cloudinarySource() {
        return new CloudinaryImageHandler(env.getProperty("cloud.url"));
    }
}
