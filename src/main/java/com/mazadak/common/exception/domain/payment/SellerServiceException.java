package com.mazadak.common.exception.domain.payment;

import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SellerServiceException extends MazadakException { // TODO: Delete if not needed, Not Used Anywhere
    private final String sellerId;

    public SellerServiceException(String message, String sellerId, HttpStatus status) {
        super(message, status, "Seller Service Failure");
        this.sellerId = sellerId;
    }

    public SellerServiceException(String message, String sellerId, HttpStatus status, Throwable cause) {
        super(message, status, "Seller Service Failure", cause);
        this.sellerId = sellerId;
    }
}