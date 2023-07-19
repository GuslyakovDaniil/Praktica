package com.example.springdatabasicdemo.controllers.AuthorController;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super("Author not found");
    }
}

