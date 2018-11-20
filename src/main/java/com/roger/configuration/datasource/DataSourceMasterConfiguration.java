package com.roger.configuration.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by lxl on 16/10/10.
 */
@Configuration
@MapperScan(basePackages = "com.roger.mapper.primary", sqlSessionFactoryRef = "ds1SqlSessionFactory")
public class DataSourceMasterConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSourceProperties dsp1() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.master.hikari")
    public DataSource ds1() {
        return dsp1().initializeDataSourceBuilder().build();
    }

    @Bean(name = "ds1TransactionManager")
    @Primary
    public PlatformTransactionManager ds1TransactionManager() {
        return new DataSourceTransactionManager(ds1());
    }

    @Bean(name = "ds1SqlSessionFactory")
    @Primary
    public SqlSessionFactory ds1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1());

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.roger.vo");
        return sessionFactory.getObject();
    }
}
