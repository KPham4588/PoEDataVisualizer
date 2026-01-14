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

    private String name;
    private String username;
    private String password;
    private String driverClassName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        System.out.println("Getting AWS secrets for application.properties");
        Properties databaseSecrets = SecretsHelper.getDBInformation();

        System.out.println("Setting application.properties settings");
    }
}
