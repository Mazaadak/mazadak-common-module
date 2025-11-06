package com.mazadak.common.exception.domain.order;

public class CheckoutCancelledException extends RuntimeException {
    public CheckoutCancelledException(String message) {
        super(message);
    }
}
