package com.mazadak.common.exception.domain.order;

import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Getter
public class CartOwnershipException extends MazadakException { // TODO: Delete if not needed, Not Used Anywhere
    private final UUID cartId, userId;

    public CartOwnershipException(String message, UUID cartId, UUID userId) {
        super(message, HttpStatus.BAD_REQUEST, "Cart Ownership Exception");
        this.cartId = cartId;
        this.userId = userId;
    }
}
