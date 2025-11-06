package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UnauthorizedException extends MazadakException {
    public UnauthorizedException(String message) {
        super(message, HttpStatus.FORBIDDEN, "Action Unauthorized");
    }
}
