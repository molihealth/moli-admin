package com.moli.admin.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by gary on 17/8/26.
 */

@Configurable
public class DataSourceConfig {

    @Bean(name = "moliDataSource")
    @Qualifier("moliDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.moli")
    public DataSource moliDataSource(){
        return DataSourceBuilder.create().build();
    }

}
