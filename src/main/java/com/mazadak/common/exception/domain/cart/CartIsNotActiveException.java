package com.mazadak.common.exception.domain.cart;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class CartIsNotActiveException extends MazadakException {
    public CartIsNotActiveException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Cart Is Not Active");
    }
}
