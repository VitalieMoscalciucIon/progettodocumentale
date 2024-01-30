package com.cedacri.progetoDocumentale.exception.model;

import java.time.LocalDate;
import java.util.Map;

public record ValidationErrorDetails(LocalDate timestamp, Map<String, String> errors, String description) {
}
