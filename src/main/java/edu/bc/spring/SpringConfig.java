package edu.bc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import edu.bc.base.CoreApp;

@Configuration
@EnableScheduling
public class SpringConfig {
	
	@Autowired
	CoreApp core;
	
	@Scheduled(fixedDelayString = "10000")
	public void scheduleFixedDelayTask() {
	    core.addBlock();
	}
	
}
