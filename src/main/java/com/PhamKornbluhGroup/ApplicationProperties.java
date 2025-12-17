package com.PhamKornbluhGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ApplicationProperties implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // Fetch the database credentials

        System.out.println("Getting AWS secrets for application.properties");
        Properties databaseSecrets = SecretsHelper.getDBInformation();

        System.out.println("Setting application.properties settings");
        //environment.getSystemProperties().put("spring.datasource.url", databaseSecrets.getProperty("url"));
        //environment.getSystemProperties().put("spring.datasource.username", databaseSecrets.getProperty("username"));
        //environment.getSystemProperties().put("spring.datasource.password", databaseSecrets.getProperty("password"));
        //environment.getSystemProperties().put("spring.datasource.driver-class-name", databaseSecrets.getProperty("driver"));
    }
}
