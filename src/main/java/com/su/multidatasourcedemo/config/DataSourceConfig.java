package com.su.multidatasourcedemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary // 定义主数据源
    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")//原博主这里加上@Qualify 没有必要 删了也没有影响
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondaryDataSource")
//    @Qualifier("secondaryDataSource") //原博主这里加上@Qualify 没有必要 删了也没有影响
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }



    /**
     * @param dataSource
     * @return
     * @Bean明确地指示了一种方法，什么方法呢——产生一个bean的方法， 并且交给Spring容器管理；从这我们就明白了为啥@Bean是放在方法的注释上了，
     * 因为它很明确地告诉被注释的方法，你给我产生一个Bean，然后交给Spring容器，
     * 实现依赖注入
     */
    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}