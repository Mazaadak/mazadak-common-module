package com.mazadak.common.exception.domain.inventory;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotEnoughStockException extends MazadakException {
    
    public NotEnoughStockException(UUID productId, int requested, int available) {
        super(
                String.format("Not enough stock for product ID: %s. Requested: %d, Available: %d", productId, requested, available),
                HttpStatus.CONFLICT,
                "Not Enough Stock");
    }
}
