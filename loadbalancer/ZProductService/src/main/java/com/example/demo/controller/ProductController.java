package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product") // ✅ This matches "/product/**"
public class ProductController {

	@Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Product Service on port: " + port;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable String id) {
        return "Product details for ID: " + id;
    }
}

