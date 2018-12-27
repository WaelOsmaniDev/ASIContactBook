package org.hexavibe.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyJpaRepository extends JpaRepository<CompanyJpa, UUID> {

    CompanyJpa findByBusinessName();

    CompanyJpa findBySirenNumber();
}
