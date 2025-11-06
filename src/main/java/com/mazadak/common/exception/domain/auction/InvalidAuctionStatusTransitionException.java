package com.mazadak.common.exception.domain.auction;

import com.mazadak.auctions.model.enumeration.AuctionStatus;

public class InvalidAuctionStatusTransitionException extends RuntimeException {
    private final AuctionStatus from, to;
    public InvalidAuctionStatusTransitionException(String message, AuctionStatus from, AuctionStatus to) {
        super(message);
        this.from = from;
        this.to = to;
    }
}
