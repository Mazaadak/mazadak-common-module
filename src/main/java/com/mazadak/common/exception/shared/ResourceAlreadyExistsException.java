package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceAlreadyExistsException extends MazadakException {
    public ResourceAlreadyExistsException(String resource, String field, String value) {
        super(String.format("%s already exists with %s = %s", resource, field, value), HttpStatus.BAD_REQUEST, "Resource Already Exists");
    }

    public ResourceAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Resource Already Exists");
    }
}
