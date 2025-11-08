package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class ResourceUploadFailedException extends MazadakException {
    public ResourceUploadFailedException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Resource Upload Failed");
    }
}
