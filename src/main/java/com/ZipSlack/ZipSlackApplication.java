package com.ZipSlack;

import com.ZipSlack.model.Emoji;
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


	public static void main(String[] args) {
		SpringApplication.run(ZipSlackApplication.class, args);


	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Emoji quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Emoji.class);
			log.info(quote.toString());
		};
	}
}