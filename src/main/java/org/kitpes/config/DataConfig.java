package org.kitpes.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource() throws SQLException, ClassNotFoundException {
        /* Database connection data */
        String url = "jdbc:mysql://mysql-t2micro.c6wjr65m2iif.us-west-2.rds.amazonaws.com:3306";
        String db = "students_assistant";
        String username = "student";
        String password = "student";

        /* Set driver and connection data */
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(url + "/" + db);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
