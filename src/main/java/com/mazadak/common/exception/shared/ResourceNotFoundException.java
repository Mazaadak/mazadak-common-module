package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends MazadakException {
    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s not found with %s = %s", resource, field, value), HttpStatus.NOT_FOUND, "Resource Not Found");
    }

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, "Resource Not Found");
    }
}
