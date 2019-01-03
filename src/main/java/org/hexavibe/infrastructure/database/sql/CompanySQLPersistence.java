package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyPersistencePort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
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
    public Company saveCompany(Company company) {
        CompanyJpa companyJpaInDB = this.companyJpaRepository.findByBusinessName(company.getBusinessName());
        if ( companyJpaInDB == null) {
            return CompanyJpaAssembler.toCompany(this.companyJpaRepository.save(CompanyJpaAssembler.toCompanyJpa(company)));
        }
        return CompanyJpaAssembler.toCompany(companyJpaInDB);
    }

}
