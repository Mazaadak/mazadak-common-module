package com.mazadak.common.exception.domain.auction;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductAlreadyHasAListedAuctionException extends MazadakException {
    public ProductAlreadyHasAListedAuctionException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Product Already Has a Listed Auction");
    }
}
