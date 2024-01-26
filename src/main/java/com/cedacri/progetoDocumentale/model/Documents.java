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
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String savedPath;
    private LocalDate savedDate;
    private String additionalInfo;
    private LocalDate groupingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Institutions institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable=false)
    private DocumentTypes documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Projects project;
}
