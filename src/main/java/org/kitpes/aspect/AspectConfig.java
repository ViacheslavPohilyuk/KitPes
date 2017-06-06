package org.kitpes.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by mac on 05.06.17.
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public LoggingAspect loggingBean() {
        return new LoggingAspect();
    }
}
