package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionsRepository extends JpaRepository<Institutions,Long> {
}
