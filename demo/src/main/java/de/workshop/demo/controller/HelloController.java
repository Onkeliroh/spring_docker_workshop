package de.workshop.demo.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Counter counter;

	public HelloController(MeterRegistry meterRegistry) {
		counter = meterRegistry.counter("de.workshop.demo.controller.hellocontroller.calls");
	}


	@GetMapping("/hello")
	public String sayHello() {
		counter.increment();
		return "Hello World";
	}
}
