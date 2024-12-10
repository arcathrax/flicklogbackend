package com.bztf.springProject.Exception;

public class RegisseurNotFoundException extends RuntimeException{
    public RegisseurNotFoundException(Long id) {
        super("Could not find Director " + id);
    }
}
