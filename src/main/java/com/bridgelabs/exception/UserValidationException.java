package com.bridgelabs.exception;

public class UserValidationException extends Exception {
    public ExceptionType exceptionType;

    public enum ExceptionType {
        INVALID_PASSWORD, INVALID_EMAILID, INVALID_FIRSTNAME, INVALID_LASTNAME, INVALID_PHONENUMBER;
    }

    public UserValidationException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}