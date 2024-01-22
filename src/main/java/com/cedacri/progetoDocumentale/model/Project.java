package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DMProjects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="institution_id", nullable=false)
    private Institution institution;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private LocalDate dateFrom;
    private LocalDate dateTill;
    private String additionalInfo;
    private Boolean isActive;
}
