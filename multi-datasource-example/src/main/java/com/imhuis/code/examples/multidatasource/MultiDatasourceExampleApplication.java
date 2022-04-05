package com.imhuis.code.examples.multidatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class
})
public class MultiDatasourceExampleApplication implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(MultiDatasourceExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceExampleApplication.class, args);
    }

    @Autowired
    private DataSource oneDataSource;

    @Autowired
    private DataSource twoDataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("oneDataSource: {}", oneDataSource.getConnection().getClientInfo());
        log.info("twoDataSource: {}", twoDataSource.getConnection().getClientInfo());
    }
}
