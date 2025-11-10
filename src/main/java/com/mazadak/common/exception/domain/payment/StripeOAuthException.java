package com.mazadak.common.exception.domain.payment;


import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StripeOAuthException extends MazadakException {
    private final String sellerId;
    public StripeOAuthException(String message, String sellerId) {
        super(message, HttpStatus.BAD_REQUEST, "Stripe OAuth Error");
        this.sellerId = sellerId;
    }

    public StripeOAuthException(String message, String sellerId, Throwable cause) {
        super(message, HttpStatus.BAD_REQUEST, "Stripe OAuth Error", cause);
        this.sellerId = sellerId;
    }

}