package com.mazadak.common.exception.domain.auction;


import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

public class InvalidAuctionStatusTransitionException extends MazadakException {
    private final String from, to;
    public InvalidAuctionStatusTransitionException(String message, String from, String to) {
        super(message, HttpStatus.BAD_REQUEST, "Invalid Auction Status Transition");
        this.from = from;
        this.to = to;
    }
}
