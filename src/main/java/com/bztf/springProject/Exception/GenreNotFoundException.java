package com.bztf.springProject.Exception;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(Long id){
        super("Could not find Genre" + id);
    }
}
