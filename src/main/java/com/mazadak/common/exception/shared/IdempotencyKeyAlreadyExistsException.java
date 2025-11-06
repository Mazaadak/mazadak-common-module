package com.mazadak.common.exception.shared;

import com.mazadak.common.exception.base.MazadakException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdempotencyKeyAlreadyExistsException extends MazadakException {
    public IdempotencyKeyAlreadyExistsException(UUID idempotencyKey, String resource, Object arg) {
        super(
                String.format("Attempted to reuse idempotency key %s for resource %s with arg %s",
                        idempotencyKey.toString(),
                        resource,
                        arg.toString()
                ),
                HttpStatus.BAD_REQUEST,
                "Duplicated Idempotency Key"
        );
    }
}
