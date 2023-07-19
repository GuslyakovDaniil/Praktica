package com.example.springdatabasicdemo.controllers.EstimationController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EstimationNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(EstimationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deviceNotFoundHandler(EstimationNotFoundException ex) {
        return ex.getMessage();
    }
}
