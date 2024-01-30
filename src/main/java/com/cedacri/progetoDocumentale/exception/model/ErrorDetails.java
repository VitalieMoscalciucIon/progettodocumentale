package com.cedacri.progetoDocumentale.exception.model;

import java.time.LocalDate;

public record ErrorDetails(LocalDate timestamp, String msg, String description) {
}
