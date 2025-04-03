package com.Nil.Electronic.Shop.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not Found Exception !!");
    }

    public ResourceNotFoundException(String Message) {
        super(Message);
    }

}
