package com.active.shoppe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class ClientAlreadyInUseException extends RuntimeException {

    private final String uniqueId;

    public ClientAlreadyInUseException(String uniqueId) {
        super(String.format("%s already in use ", uniqueId));
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

}