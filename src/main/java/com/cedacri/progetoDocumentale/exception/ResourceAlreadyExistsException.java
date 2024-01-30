package com.cedacri.progetoDocumentale.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException() {
        super("resource with specified values already exists");
    }
}
