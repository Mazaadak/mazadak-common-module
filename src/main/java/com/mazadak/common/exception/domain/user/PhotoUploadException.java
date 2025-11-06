package com.mazadak.common.exception.domain.user;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class PhotoUploadException extends MazadakException {
    public PhotoUploadException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "Photo Upload Failed");
    }
}
