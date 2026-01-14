package com.PhamKornbluhGroup;

import java.util.Properties;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

public class DatabasePropertiesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        Properties databaseSecrets = SecretsHelper.getDBInformation();

        ConfigurableEnvironment environment = event.getEnvironment();
        Properties props = new Properties();
        props.put("spring.datasource.url", databaseSecrets.getProperty("url"));
        props.put("spring.datasource.username", databaseSecrets.getProperty("username"));
        props.put("spring.datasource.password", databaseSecrets.getProperty("password"));
        props.put("spring.datasource.driver-class-name", databaseSecrets.getProperty("driver"));
        environment.getPropertySources().addFirst(new PropertiesPropertySource("POEDataVisualizer", props));
    }
}
