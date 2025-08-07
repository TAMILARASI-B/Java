package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        logger.debug("This is a debug message.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");
    }
}
