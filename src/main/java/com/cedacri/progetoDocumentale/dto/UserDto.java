package com.cedacri.progetoDocumentale.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{1,32}$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{1,255}$")
    private String password;

    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;
    private String patronymic;

    @NotBlank
    private String institution;

    @NotNull
    private List<String> roles;

    @NotNull
    private boolean active;
}
