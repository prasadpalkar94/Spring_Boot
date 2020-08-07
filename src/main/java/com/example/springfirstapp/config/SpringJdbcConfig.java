package com.example.springfirstapp.config;

import javax.activation.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJdbcConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringJdbcConfig.class);

    @Bean
//    public DataSource mysqlDataSource() {
    public static DriverManagerDataSource mysqlDataSource() {
        LOGGER.debug("inside mysqlDataSource()");
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_data");
        dataSource.setUsername("root");
        dataSource.setPassword("root1234");
        LOGGER.debug("inside mysqlDataSource()--> dataSource: ", dataSource);
//        return (DataSource) dataSource;
        return dataSource;
    }
}
