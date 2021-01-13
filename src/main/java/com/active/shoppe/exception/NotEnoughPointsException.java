package com.active.shoppe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class NotEnoughPointsException extends RuntimeException {

    public NotEnoughPointsException() {
        super(String.format("customer does not have enough points"));
    }
}