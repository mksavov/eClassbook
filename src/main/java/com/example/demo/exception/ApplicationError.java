package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationError extends RuntimeException {

   private final String message;

   private final HttpStatus statusCode;
}