package com.mazadak.common.exception.domain.cart;

public class CartIsNotActiveException extends RuntimeException {
    public CartIsNotActiveException(String message) {
        super(message);
    }
}
