package com.mazadak.common.exception.domain.payment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefundFailureException extends RuntimeException {
    public RefundFailureException(String message) {
        super(message);
    }
}
