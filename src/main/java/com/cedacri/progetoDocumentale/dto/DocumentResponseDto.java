package com.cedacri.progetoDocumentale.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class DocumentResponseDto {
    private String savedPath;
    private Long macroId;
    private LocalDate groupingDate;
}
