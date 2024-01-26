package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTill;
    private String additionalInfo;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Institutions institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Users user;
}
