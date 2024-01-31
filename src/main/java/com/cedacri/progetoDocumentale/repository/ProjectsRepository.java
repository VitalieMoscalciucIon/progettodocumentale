package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
