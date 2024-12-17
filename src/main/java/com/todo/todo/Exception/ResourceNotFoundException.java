package com.todo.todo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String Message){
        super(Message); 
//When you call super(Message) in the constructor of ResourceNotFoundException,
//you are calling the constructor of the superclass (RuntimeException) 
//that takes a String parameter
    }
}