package org.kitpes.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:localhost_jdbc.properties"),
        @PropertySource("classpath:hibernate_settings.properties")
})
@ComponentScan({"org.kitpes"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(
                new String[]{"org.kitpes.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(env.getProperty("jdbc.url") + "/" +
                env.getProperty("jdbc.db") + "?" +
                env.getProperty("jdbc.settings"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager txManager
                = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hb.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hb.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hb.show_sql"));
                setProperty("hibernate.globally_quoted_identifiers", env.getProperty("hb.gqi"));
            }
        };
    }
}
