package com.example.springdatabasicdemo.controllers.EstimationController;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EstimationNotFoundException extends RuntimeException{
    public EstimationNotFoundException() {
        super("Estimation not found");
    }
}

