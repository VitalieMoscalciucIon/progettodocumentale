package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Institutions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institutions, Long> {
    Institutions findByName(String name);
}
