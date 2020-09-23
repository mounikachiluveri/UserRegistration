package com.bridgelabs.exception;

public class UserValidationException extends Exception {
    public enum ExceptionType {
        INVALID_PASSWORD, INVALID_EMAILid;
    }

    public ExceptionType type;

    public UserValidationException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}