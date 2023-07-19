package com.example.springdatabasicdemo.controllers.BookController;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("Book not found");
    }
}

