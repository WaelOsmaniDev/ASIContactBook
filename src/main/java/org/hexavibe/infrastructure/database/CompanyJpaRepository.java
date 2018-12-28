package org.hexavibe.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyJpa, UUID> {

    CompanyJpa findByBusinessName(String businessName);

    CompanyJpa findBySirenNumber(String sirenNumber);
}
