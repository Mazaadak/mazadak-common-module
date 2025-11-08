package com.mazadak.common.exception.domain.user;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends MazadakException {
    public InvalidTokenException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "Invalid Token");
    }
}
