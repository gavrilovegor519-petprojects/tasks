package com.egor.tasks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Incorrect password!")
public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword() {
        super();
    }

    public IncorrectPassword(String message) {
        super(message);
    }

    public IncorrectPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPassword(Throwable cause) {
        super(cause);
    }

    protected IncorrectPassword(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
