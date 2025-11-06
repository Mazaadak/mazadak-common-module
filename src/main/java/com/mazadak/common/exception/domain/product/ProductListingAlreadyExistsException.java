package com.mazadak.common.exception.domain.product;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class ProductListingAlreadyExistsException extends MazadakException {
    public ProductListingAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Product Listing Already Exists");
    }
}
