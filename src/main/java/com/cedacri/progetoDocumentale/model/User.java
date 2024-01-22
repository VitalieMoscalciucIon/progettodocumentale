package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DMUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="institution_id", nullable=false)
    private Institution institution;
    private String username;
    private String password;
    private String email;
    private Boolean isEnabled;
    private String name;
    private String surname;
    private String patronymic;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DMUserToRole",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<UserRole> roles;
}
