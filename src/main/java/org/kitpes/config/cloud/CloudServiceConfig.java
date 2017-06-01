package org.kitpes.config.cloud;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mac on 19.05.17.
 */
@Configuration
public class CloudServiceConfig {
    @Bean
    public CloudService cloudSource() {
        return new CloudinaryCloud();
    }
}
