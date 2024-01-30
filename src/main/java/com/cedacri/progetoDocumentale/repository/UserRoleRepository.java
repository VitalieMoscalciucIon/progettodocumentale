package com.cedacri.progetoDocumentale.repository;

import com.cedacri.progetoDocumentale.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
    List<UserRoles> getByRoleNameIn(List<String> names);
}
