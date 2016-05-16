package com.example.fiskenatet.logging;

import com.example.fiskenatet.Application;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by nordi_000 on 2016-05-16.
 */
public class Logging {

    private static Logger log = Logger.getLogger(Application.class.getName());

    public Logger createLog() {
        try {
            FileHandler fileHandler = new FileHandler("logging.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }

}
