package com.mazadak.common.exception.domain.payment;

import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PaymentProcessingException extends MazadakException {

    public PaymentProcessingException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Payment Processing Failed");
    }

}