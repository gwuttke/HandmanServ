package de.gtwsp21.handmanserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import de.gtwsp21.handmanserv.init.ConfigProperties;

@SpringBootApplication
public class HandmanServApplication {

	@Autowired
	private ConfigProperties configProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(HandmanServApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void logConfigs() {
	    System.out.println(String.format("Der Testmodus ist: %b", configProperties.isTestmodus()));
	}
	
}