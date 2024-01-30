package com.cedacri.progetoDocumentale.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{1,5}$")
    private String instCode;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{1,64}$")
    private String name;
    private String additionalInfo;
}
