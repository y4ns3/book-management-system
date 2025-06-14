package com.bookmanager.rest.exceptions;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String message){
        super(message);
    }
}
