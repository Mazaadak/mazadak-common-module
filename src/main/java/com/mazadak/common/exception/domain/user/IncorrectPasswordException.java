package com.mazadak.common.exception.domain.user;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends MazadakException {
    public IncorrectPasswordException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "Incorrect Password");
    }
}
