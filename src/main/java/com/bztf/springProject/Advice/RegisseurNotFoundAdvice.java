package com.bztf.springProject.Advice;

import com.bztf.springProject.Exception.MovieNotFoundException;
import com.bztf.springProject.Exception.RegisseurNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegisseurNotFoundAdvice {
    @ExceptionHandler(RegisseurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String regisseurNotFoundHandler(MovieNotFoundException ex){
        return ex.getMessage();
    }
}