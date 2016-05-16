package com.example.fiskenatet;

import com.example.fiskenatet.logging.Logging;
import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.services.ProductService;
import com.example.fiskenatet.services.UserService;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@SpringBootApplication
public class Application {





	public static void main(String[] args) {


		Logging logging = new Logging();
		Logger log = logging.createLog();

		log.info("Going to start the whole application");
		SpringApplication.run(Application.class, args);

		System.out.println("Hello Sweden!!!!!");

		log.info("Hello sweden har skrivits ut..");
		log.info("Här kommer en ny rad");


	}



}
