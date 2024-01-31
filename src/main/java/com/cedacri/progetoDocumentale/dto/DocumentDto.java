package com.cedacri.progetoDocumentale.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentDto {

    @NotBlank
    private String savedPath;

    @NotBlank
    private String institution;

    @NotBlank
    private String macroType;
    private String microType;
    private String project;

    @NotNull
    private LocalDate groupingDate;
    private String additionalInfo;
}
