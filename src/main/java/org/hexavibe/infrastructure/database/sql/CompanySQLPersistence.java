package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class CompanySQLPersistence implements CompanyPersistencePort {

    private final CompanyJpaRepository companyJpaRepository;

    public CompanySQLPersistence(CompanyJpaRepository companyJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public Company getCompanyByBusinessName(String businessName) {
        return CompanyJpaAssembler.toCompany(companyJpaRepository.findByBusinessName(businessName));
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return CompanyJpaAssembler.toCompany(companyJpaRepository.findBySirenNumber(sirenNumber));
    }

    @Override
    public void saveCompany(Company company) {
        if(this.companyJpaRepository.findByBusinessName(company.getBusinessName()) == null) {
            this.companyJpaRepository.save(CompanyJpaAssembler.toCompanyJpa(company));
        }
    }

}
