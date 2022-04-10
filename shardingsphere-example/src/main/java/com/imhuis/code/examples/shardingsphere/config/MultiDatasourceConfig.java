package com.imhuis.code.examples.shardingsphere.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author: imhuis
 * @date: 2021/12/21
 * @description:
 */
@Configuration
public class MultiDatasourceConfig {

    /**
     * 数据源1
     */
    @Bean
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSourceProperties dataSourceOneProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oneDataSource(DataSourceProperties dataSourceOneProperties) {
        return dataSourceOneProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager oneTxManager(DataSource oneDataSource) {
        return new DataSourceTransactionManager(oneDataSource);
    }

    /**
     * 数据源2
     */
    @Bean
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSourceProperties dataSourceTwoProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource twoDataSource(DataSourceProperties dataSourceTwoProperties) {
        return dataSourceTwoProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager twoTxManager(DataSource twoDataSource) {
        return new DataSourceTransactionManager(twoDataSource);
    }
}
