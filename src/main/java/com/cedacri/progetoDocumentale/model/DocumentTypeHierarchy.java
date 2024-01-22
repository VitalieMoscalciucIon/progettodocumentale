package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DMDocumentTypeHierarchy")
public class DocumentTypeHierarchy {
    @Id
    @Column(name = "id_macro")
    private Long id;
}
