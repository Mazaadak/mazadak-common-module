package com.mazadak.common.exception.domain.payment;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefundFailureException extends MazadakException {
    public RefundFailureException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Refund Failed");
    }
}
