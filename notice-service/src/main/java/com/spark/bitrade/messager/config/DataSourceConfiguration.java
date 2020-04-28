package com.spark.bitrade.messager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

/**
 * @author ww
 * @time 2019.09.27 23:16
 */
@Configuration
@Slf4j
public class DataSourceConfiguration {

    @Value("${mybatis.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 写库 数据源配置
     *
     * @return
     */
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource() {
        log.info("writeDataSource init ...");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 有多少个从库就要配置多少个
     *
     * @return
     */
    @Bean(name = "readDataSource01")
    @ConfigurationProperties(prefix = "mysql.datasource.read01")
    public DataSource readDataSourceOne() {
        log.info("read01 DataSourceOne init ...");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource02")
    @ConfigurationProperties(prefix = "mysql.datasource.read02")
    public DataSource readDataSourceTwo() {
        log.info("read02 DataSourceTwo init ...");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }


}
