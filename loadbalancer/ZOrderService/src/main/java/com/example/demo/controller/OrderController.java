package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order") // ✅ This matches "/order/**"
public class OrderController {

    @GetMapping("/hello")
    public String getOrderMessage() {
        return "Hello from Order Service!";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable String id) {
        return "Order details for ID: " + id;
    }
}

