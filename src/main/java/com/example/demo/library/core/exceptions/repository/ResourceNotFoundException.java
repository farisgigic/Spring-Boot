package com.example.demo.library.core.exceptions.repository;

import com.example.demo.library.core.exceptions.GeneralException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends GeneralException {
    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
    public ResourceNotFoundException(){
        super(HttpStatus.NOT_FOUND.value());
    }
}
