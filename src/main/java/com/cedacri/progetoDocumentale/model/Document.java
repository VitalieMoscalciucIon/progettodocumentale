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
@Table(name = "DMDocuments")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="institution_id", nullable=false)
    private Institution institution;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne
    @JoinColumn(name="document_type_id", nullable=false)
    private DocumentType documentType;
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;
    private String savedPath;
    private LocalDate savedDate;
    private String additionalInfo;
    private LocalDate groupingDate;
}
