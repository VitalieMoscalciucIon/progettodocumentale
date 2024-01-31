package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
