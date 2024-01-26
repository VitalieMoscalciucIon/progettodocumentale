package com.cedacri.progetoDocumentale.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class DocumentTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String typeDescription;
    private Boolean isMacro;

    @ManyToOne
    DocumentTypes macroType;
}
