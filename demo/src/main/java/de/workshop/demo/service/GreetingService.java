package de.workshop.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

Ø

@ConditionalOnProperty(prefix = "demo.greeting.target", name = {"host", "port"})
@Component
public class GreetingService {

	private final String host;
	private final String port;

	Logger log;

	@Autowired
	public GreetingService(@Value("${demo.greeting.target.host}") String host, @Value("${demo.greeting.target.port}") String port) {
		this.host = host;
		this.port = port;

		log = LoggerFactory.getLogger(this.getClass());
	}

	@Scheduled(fixedRate = 1000)
	public void greetTheNeighbor() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.newInstance().scheme("http").host(host).port(port).path("/").build().toUri();
		restTemplate.postForLocation(uri, "Hello");

		log.info("Said hello!");
	}
}
