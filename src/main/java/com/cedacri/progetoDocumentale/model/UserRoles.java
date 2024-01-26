package com.cedacri.progetoDocumentale.model;

import com.cedacri.progetoDocumentale.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Users> users;
}
