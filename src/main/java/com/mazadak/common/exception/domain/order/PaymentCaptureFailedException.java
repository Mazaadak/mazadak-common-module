package com.mazadak.common.exception.domain.order;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class PaymentCaptureFailedException extends MazadakException {
    public PaymentCaptureFailedException(UUID orderId) {
        super("Failed to capture payment for order " + orderId, HttpStatus.INTERNAL_SERVER_ERROR, "Payment Capture Failed");
    }
}
