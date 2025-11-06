package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class UnauthenticatedException extends MazadakException {
    public UnauthenticatedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "User Not Authenticated");
    }
}
