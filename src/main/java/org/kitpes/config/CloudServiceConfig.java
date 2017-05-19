package org.kitpes.config;

import com.cloudinary.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mac on 19.05.17.
 */
@Configuration
public class CloudServiceConfig {
    @Bean
    public Cloudinary cloudinarySource() {
        String url = "cloudinary://428594225923247:3Nc1lIwCQo9wU-EpePaPqrBHAT0@hyn3znmgk";
        return new Cloudinary(url);
    }
}
