package org.kitpes.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:heroku_jdbc.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        /* Database connection data */
        String url = env.getProperty("jdbc.url");
        String db = env.getProperty("jdbc.db");
        String username = env.getProperty("jdbc.username");
        String password = env.getProperty("jdbc.password");

        /* Connection parameters */
        String encoding = "useUnicode=true&characterEncoding=utf-8";
        String ssl = "autoReconnect=true&useSSL=false";

        /* Set driver and connection data */
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(url + "/" + db + "?" + encoding + "&" + ssl);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}