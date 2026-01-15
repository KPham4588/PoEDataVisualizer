package com.PhamKornbluhGroup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class PoeDataVisualizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoeDataVisualizerApplication.class, args);
	}

}
