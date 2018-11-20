package com.roger.configuration.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lxl on 16/10/10.
 */
@Configuration
@MapperScan(basePackages = "com.roger.mapper.localhost", sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class DataSourceSlave1Configuration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.slave1")
    public DataSourceProperties dsp2() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.slave1.hikari")
    public DataSource ds2() {
        return dsp2().initializeDataSourceBuilder().build();
    }

    @Bean(name = "ds2TransactionManager")
    public PlatformTransactionManager ds2TransactionManager() {
        return new DataSourceTransactionManager(ds2());
    }

    @Bean(name = "ds2SqlSessionFactory")
    public SqlSessionFactory ds2SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds2());
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.roger.model");
        return sessionFactory.getObject();
    }
}
