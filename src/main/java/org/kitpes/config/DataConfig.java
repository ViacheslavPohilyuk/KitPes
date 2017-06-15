package org.kitpes.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource() {
        /* Database connection data */
        String url = "jdbc:mysql://hngomrlb3vfq3jcr.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306";
        String db = "ydtnrkg2yazh7r4c";
        String username = "gt61wylco9krv1qj";
        String password = "vzca9pd5nlaalmhj";

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