package edu.bc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import edu.bc.base.CoreApp;

@SpringBootApplication(scanBasePackages = { "edu.bc.base", "edu.bc.spring" })
public class Application {

	@Autowired
	CoreApp core;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		core.setupGenesis();
	}

}