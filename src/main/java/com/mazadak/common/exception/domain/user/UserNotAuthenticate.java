package com.mazadak.common.exception.domain.user;

public class UserNotAuthenticate extends RuntimeException {
    public UserNotAuthenticate(String message) {
        super(message);
    }
}
