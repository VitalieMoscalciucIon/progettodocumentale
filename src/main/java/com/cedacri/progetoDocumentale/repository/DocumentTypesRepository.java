package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.DocumentTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypesRepository extends JpaRepository<DocumentTypes,Long> {
}
