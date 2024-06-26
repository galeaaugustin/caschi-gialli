package com.caschigialli.api.errors;

import java.io.Serializable;

public class InvalidRolesProvidedException extends DomainDataException {

    public InvalidRolesProvidedException(String message, Serializable entity) {
        super(message, entity);
    }

    public InvalidRolesProvidedException(String message) {
        super(message, null);
    }
}
