package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
