package com.smartloan.auth.authentication.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (Long userId) {
        super("User not found for id : " + userId);
    }
}
