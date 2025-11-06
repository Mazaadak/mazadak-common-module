package com.mazadak.common.exception.domain.user;

import com.mazadak.common.exception.base.MazadakException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmailNotVerifiedException extends MazadakException { // TODO: Delete if not needed, Not Used Anywhere
    private final String email;

    public EmailNotVerifiedException(String email) {
        super(String.format("Account %s is not verified.", email), HttpStatus.FORBIDDEN, "Email Not Verified");
        this.email = email;
    }
}
