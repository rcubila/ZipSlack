package com.ZipSlack;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZipSlackApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] data) {
		SpringApplication.run(ZipSlackApplication.class, data);

	}


}