package com.cedacri.progetoDocumentale.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class DocumentRequestDto {
    @NotBlank
    private String savedPath;
    private Long institutionId;
    private Long macroId;
    private Long projectId;
    private String groupingDate;
    private String additionalInfo;
    private Long userId;
}
