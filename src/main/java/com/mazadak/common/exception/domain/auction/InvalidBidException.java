package com.mazadak.common.exception.domain.auction;


import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBidException extends MazadakException {
    public InvalidBidException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "Invalid Bid");
    }

    public InvalidBidException(BigDecimal bidAmount, BigDecimal minAllowedBid) {
        super(
                String.format("%s is insufficient bid amount, bid must be at least %s", bidAmount, minAllowedBid),
                HttpStatus.BAD_REQUEST,
                "Invalid Bid"
        );
    }
}
