package com.example.demo.controller;

import com.example.demo.exception.ApplicationError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

   @ExceptionHandler(ApplicationError.class)
   public ResponseEntity<Object> handleApplicationError(ApplicationError applicationError) {
      return new ResponseEntity<>(applicationError.getMessage(), applicationError.getStatusCode());
   }
}