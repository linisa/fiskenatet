package com.example.fiskenatet;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.services.HistoryService;
import com.example.fiskenatet.services.UserService;
import com.example.fiskenatet.timer.TimerHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


@SpringBootApplication
public class Application {

	public static final Logger log = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		/*
		try {
			FileHandler fileHandler = new FileHandler("logging.txt");
			fileHandler.setFormatter(new SimpleFormatter());
			log.addHandler(fileHandler);
			log.info("Program started and new log file was created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

		//Timer timer = new Timer();
		// Kör TimerHandler var tionde sekund
		//timer.schedule(new TimerHandler(), 0, 10000);

		// "köp nu" sätter kopplar till fel köpare. bidder_id blir fel
		// alert meddelande när man skapat en ny användare. "användare skapade"

	}
}
