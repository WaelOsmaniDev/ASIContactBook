package org.hexavibe.infrastructure.database.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyJpa, Long> {

    CompanyJpa findByBusinessName(String businessName);

    CompanyJpa findBySirenNumber(String sirenNumber);
}
