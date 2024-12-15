package com.example.demo.library.core.exceptions.general;

import com.example.demo.library.core.exceptions.GeneralException;

public class BadRequestException extends GeneralException {
    public BadRequestException(String message){
        super(message);
    }
}
