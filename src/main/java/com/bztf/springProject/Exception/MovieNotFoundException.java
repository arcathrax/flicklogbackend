package com.bztf.springProject.Exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Could not find Movie " + id);
    }
}