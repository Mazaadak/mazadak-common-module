package com.mazadak.common.exception.domain.order;

import com.mazadak.common.exception.base.MazadakException;

public class CheckoutTimeoutException extends RuntimeException { // TODO: Extend MazadakException?
    public CheckoutTimeoutException(String message) {
        super(message);
    }
}
