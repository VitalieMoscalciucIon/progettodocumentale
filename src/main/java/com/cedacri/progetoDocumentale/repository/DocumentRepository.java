package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Documents,Long> {
}
