package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Documents, Long> {
}
