package com.example.bookapi.exception;


public class ResourceNotFoundException extends RuntimeException {
 public ResourceNotFoundException(String message) {
     super(message);
 }
}

