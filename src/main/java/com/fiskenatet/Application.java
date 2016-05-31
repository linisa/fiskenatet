package com.fiskenatet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Application {

	public static final Logger log = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
/*
		try {
			FileHandler fileHandler = new FileHandler("logging.txt", true);
			fileHandler.setFormatter(new SimpleFormatter());
			log.addHandler(fileHandler);
			log.info("Program started and new log file was created");
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
	}

}
