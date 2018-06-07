package de.workshop.demo.service.impl;

import de.workshop.demo.service.IGreeterSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UnfriendlyGreeterService implements IGreeterSevice {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void greet() {
		log.info("go away");
	}
}
