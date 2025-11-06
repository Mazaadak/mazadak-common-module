package com.mazadak.common.exception.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class MazadakException extends RuntimeException {
    private final HttpStatus status;
    private final String title;

    public MazadakException(String message, HttpStatus status, String title) {
        super(message);
        this.status = status;
        this.title = title;
    }

    public MazadakException(String message, HttpStatus status, String title, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.title = title;
    }
}
