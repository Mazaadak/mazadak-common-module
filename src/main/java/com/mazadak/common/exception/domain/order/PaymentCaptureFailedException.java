package com.mazadak.common.exception.domain.order;

import java.util.UUID;

public class PaymentCaptureFailedException extends RuntimeException {
    public PaymentCaptureFailedException(UUID orderId) {
        super("Failed to capture payment for order " + orderId);
    }
}
