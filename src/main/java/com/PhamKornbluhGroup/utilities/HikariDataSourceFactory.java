package com.PhamKornbluhGroup.utilities;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

// This runs due to <dataSource type = ...> settings in mybatisconfig.xml
public class HikariDataSourceFactory implements DataSourceFactory {
    private HikariDataSource dataSource;

    @Override
    public void setProperties(Properties props) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(props.getProperty("url"));
        config.setUsername(props.getProperty("username"));
        config.setPassword(props.getProperty("password"));
        config.setDriverClassName(props.getProperty("driver"));

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30_000);
        config.setIdleTimeout(600_000);
        config.setMaxLifetime(1_800_000);
        config.setPoolName("mybatis-hikari-pool");

        dataSource = new HikariDataSource(config);
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}