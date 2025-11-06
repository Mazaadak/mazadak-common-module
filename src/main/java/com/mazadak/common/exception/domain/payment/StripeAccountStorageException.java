package com.mazadak.common.exception.domain.payment;

import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

@Getter
public class StripeAccountStorageException extends MazadakException {
    private final String sellerId;
    private final String stripeAccountId;

    public StripeAccountStorageException(String message, String sellerId, String stripeAccountId) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "Stripe Account Storage Failure");
        this.sellerId = sellerId;
        this.stripeAccountId = stripeAccountId;
    }

    public StripeAccountStorageException(String message, String sellerId, String stripeAccountId, Throwable cause) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "Stripe Account Storage Failure", cause);
        this.sellerId = sellerId;
        this.stripeAccountId = stripeAccountId;
    }

}