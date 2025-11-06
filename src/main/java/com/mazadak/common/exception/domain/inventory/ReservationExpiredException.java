package com.mazadak.common.exception.domain.inventory;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class ReservationExpiredException extends MazadakException {
    public ReservationExpiredException(UUID reservationId) {
        super("Reservation expired with id: " + reservationId, HttpStatus.BAD_REQUEST, "Reservation Expired");
    }
}
