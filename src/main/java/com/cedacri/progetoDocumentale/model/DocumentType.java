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
@Table(name = "DMDocumentTypes")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Long id;
    private String code;
    private String name;
    private String typeDscr;
    private Boolean isMacro;
    private LocalDate isDateGrouped;
    @ManyToOne
    @JoinColumn(name = "id_macro")
    private DocumentTypeHierarchy documentTypeHierarchy;
}
