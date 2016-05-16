package com.example.fiskenatet;

import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.services.BidService;
import com.example.fiskenatet.services.ProductService;
import com.example.fiskenatet.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


@SpringBootApplication
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
