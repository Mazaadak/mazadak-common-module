package com.mazadak.common.exception.domain.order;

import com.mazadak.common.exception.base.MazadakException;

public class CheckoutCancelledException extends RuntimeException { // TODO: Extend MazadakException?
    public CheckoutCancelledException(String message) {
        super(message);
    }
}
