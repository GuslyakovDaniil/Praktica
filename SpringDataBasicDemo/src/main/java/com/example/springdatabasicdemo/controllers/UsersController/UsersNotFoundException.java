package com.example.springdatabasicdemo.controllers.UsersController;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UsersNotFoundException extends RuntimeException{
    public UsersNotFoundException() {
        super("Estimation not found");
    }
}

