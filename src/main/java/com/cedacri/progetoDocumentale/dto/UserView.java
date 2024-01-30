package com.cedacri.progetoDocumentale.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserView {
    private String username;
    private String name;
    private String email;
    private boolean isActive;
}
