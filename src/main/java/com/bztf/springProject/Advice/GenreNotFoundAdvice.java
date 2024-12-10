package com.bztf.springProject.Advice;

import com.bztf.springProject.Exception.GenreNotFoundException;
import com.bztf.springProject.Exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenreNotFoundAdvice {
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String genreNotFoundHandler(GenreNotFoundException ex){
        return ex.getMessage();
    }
}
