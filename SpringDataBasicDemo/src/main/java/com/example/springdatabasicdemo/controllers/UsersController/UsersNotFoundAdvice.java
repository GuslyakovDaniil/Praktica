package com.example.springdatabasicdemo.controllers.UsersController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsersNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UsersNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deviceNotFoundHandler(UsersNotFoundException ex) {
        return ex.getMessage();
    }
}
