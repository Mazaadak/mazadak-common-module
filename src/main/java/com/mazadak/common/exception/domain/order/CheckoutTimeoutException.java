package com.mazadak.common.exception.domain.order;

public class CheckoutTimeoutException extends RuntimeException {
    public CheckoutTimeoutException(String message) {
        super(message);
    }
}
