package com.active.shoppe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    private final String uniqueId;


    public ClientNotFoundException(String uniqueId) {
        super(String.format("Client  not found with id number %s : '%s'", uniqueId));
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }
    
}