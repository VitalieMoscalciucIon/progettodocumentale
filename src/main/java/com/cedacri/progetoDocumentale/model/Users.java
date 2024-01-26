package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Institutions institution;

    private String username;
    private String password;
    private String email;
    private Boolean isEnabled;
    private String name;
    private String surname;
    private String patronymic;

    @ManyToMany
    private List<UserRoles> roles;
}
