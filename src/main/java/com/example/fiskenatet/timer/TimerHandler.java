package com.example.fiskenatet.timer;

import com.example.fiskenatet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimerTask;


public class TimerHandler extends TimerTask {
    public void run() {
        System.out.println("Print every 10 seconds!!!!");
    }
}
