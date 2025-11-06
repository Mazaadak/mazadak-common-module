package com.mazadak.common.exception.domain.product;

public class ProductListingAlreadyExistsException extends RuntimeException {
    public ProductListingAlreadyExistsException(String message) {
        super(message);
    }
}
