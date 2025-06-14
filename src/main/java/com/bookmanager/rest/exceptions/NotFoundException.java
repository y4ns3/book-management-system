package com.bookmanager.rest.exceptions;

public class NotFoundException extends  RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
