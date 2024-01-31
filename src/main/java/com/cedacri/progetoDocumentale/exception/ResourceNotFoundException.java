package com.cedacri.progetoDocumentale.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("resource not found");
    }
}
