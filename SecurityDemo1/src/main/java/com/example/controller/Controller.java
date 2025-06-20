package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
@GetMapping("home")
public String home()
{
	return "<h1> Hi welcome to home page</h1>";
}
@GetMapping("abc")
public String abc()
{
	return "<h1>Hi welcome to ABC page</h1>";
}
@GetMapping("xyz")
public String xyz()
{
	return "<h1> Hi welcome to xyz page</h1>";
}
}
