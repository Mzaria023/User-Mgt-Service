package com.zoulaika.User_Management_API.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
    // constructor with a message
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }


}
