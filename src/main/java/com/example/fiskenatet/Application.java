package com.example.fiskenatet;

import com.example.fiskenatet.logging.Logging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;


@SpringBootApplication
public class Application {





	public static void main(String[] args) {


		Logging logging = new Logging();
		Logger log = logging.createLog();

		log.info("Going to start the whole application");
		SpringApplication.run(Application.class, args);

		System.out.println("Hello Sweden!!!!!");

		log.info("Hello sweden har skrivits ut..");
		log.info("hdeuhdeuhdiuehdiuehdeiuhiuedhediuhdiuehiuedhiuedhiuedh");


	}



}
