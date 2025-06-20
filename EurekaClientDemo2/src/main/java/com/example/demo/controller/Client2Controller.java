package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Eureka Client 2!";
    }
}
