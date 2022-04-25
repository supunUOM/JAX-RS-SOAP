package com.example.exception;

public class InvalidInputException extends RuntimeException {
    private String errorDetails;
    public InvalidInputException(String message, String errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

    public String getFaultInfo(){
        return errorDetails;
    }
}
