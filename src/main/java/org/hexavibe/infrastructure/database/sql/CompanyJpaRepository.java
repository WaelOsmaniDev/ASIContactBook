package org.hexavibe.infrastructure.database.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyJpa, String> {

    CompanyJpa findByBusinessName(String businessName);

    CompanyJpa findBySirenNumber(String sirenNumber);

    List<CompanyJpa> findAll();
}
