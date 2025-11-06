package com.mazadak.common.exception.domain.user;

import lombok.Getter;

@Getter
public class EmailNotVerifiedException extends RuntimeException {
    private final String email;

    public EmailNotVerifiedException(String email) {
        super(String.format("Account %s is not verified.", email));
        this.email = email;
    }
}
