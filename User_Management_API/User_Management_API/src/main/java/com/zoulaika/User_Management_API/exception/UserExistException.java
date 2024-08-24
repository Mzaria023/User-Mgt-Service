package com.zoulaika.User_Management_API.exception;

public class UserExistException extends RuntimeException{
    // constructor that accepts a message
    public UserExistException(String message) {
        super(message);
    }

    // constructor that accepts a message and a cause
    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
