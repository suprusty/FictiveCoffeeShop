package org.fictive.barista.exception;

public class BaristaNotFoundException extends RuntimeException {

    public BaristaNotFoundException(String message) {
        super(message);
    }

    public BaristaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaristaNotFoundException(Throwable cause) {
        super(cause);
    }
}
