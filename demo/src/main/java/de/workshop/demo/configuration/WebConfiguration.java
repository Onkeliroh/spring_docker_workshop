package de.workshop.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

	@Bean
	public RestTemplate produceRestTemplate(){
		return new RestTemplate();
	}
}
