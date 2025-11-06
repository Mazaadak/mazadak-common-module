package com.mazadak.common.exception.domain.payment;

import lombok.Getter;

@Getter
public class PaymentProcessingException extends RuntimeException {

    public PaymentProcessingException(String message) {
        super(message);
    }

}