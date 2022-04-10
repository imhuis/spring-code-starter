package com.imhuis.code.examples.shardingsphere.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: imhuis
 * @date: 2022/4/10
 * @description:
 */
@Configuration
public class MybatisConfig {

    @Autowired
    @Qualifier("oneDataSource")
    private DataSource dataSource1;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource1);
        return sqlSessionFactoryBean.getObject();
    }

}
