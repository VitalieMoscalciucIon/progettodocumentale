package com.cedacri.progetoDocumentale.exception;

public class DocumentTypeNotFoundException extends RuntimeException {
    public DocumentTypeNotFoundException(String message) {
        super(message);
    }
}
