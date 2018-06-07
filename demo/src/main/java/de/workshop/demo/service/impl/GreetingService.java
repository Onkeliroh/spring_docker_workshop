package de.workshop.demo.service.impl;

import de.workshop.demo.service.IGreeterSevice;
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

@ConditionalOnProperty(prefix = "demo.greeting.target", name = {"host", "port"})
@Component
public class GreetingService implements IGreeterSevice {

	private final String host;
	private final String port;

	private Logger log;
	private RestTemplate restTemplate;

	@Autowired
	public GreetingService(@Value("${demo.greeting.target.host}") String host, @Value("${demo.greeting.target.port}") String port, RestTemplate restTemplate) {
		this.host = host;
		this.port = port;
		this.restTemplate = restTemplate;

		log = LoggerFactory.getLogger(this.getClass());
	}

	@Scheduled(fixedRate = 1000)
	@Override
	public void greet() {
		URI uri = UriComponentsBuilder.newInstance().scheme("http").host(host).port(port).path("/").build().toUri();
		restTemplate.postForLocation(uri, "Hello");

		log.info("Said hello!");
	}
}
