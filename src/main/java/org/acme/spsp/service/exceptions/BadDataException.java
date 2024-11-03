package org.acme.spsp.service.exceptions;

public class BadDataException extends RuntimeException {
    public BadDataException(String message) {
        super(message);
    }
}
