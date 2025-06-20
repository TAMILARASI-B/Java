package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/fallback/product")
    public ResponseEntity<String> productFallback() {
        return ResponseEntity.ok("ZProductService is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/order")
    public ResponseEntity<String> orderFallback() {
        return ResponseEntity.ok("ZOrderService is temporarily unavailable. Please try again later.");
    }
}
