package com.infoshareacademy.restcountries.exception;

public class CountryNotFoundException extends RuntimeException {
    private String message;

    public CountryNotFoundException(String message){
        this.message=message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
