package com.mazadak.common.exception.domain.auction;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class InvalidAuctionOperationException extends MazadakException {
    public InvalidAuctionOperationException(String message, UUID id) {
        super(message + " (Auction id: " + id + ")", HttpStatus.BAD_REQUEST, "Invalid Auction Operation");
    }
}
