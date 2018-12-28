package org.hexavibe.infrastructure.database;

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
        return this.toCompany(companyJpaRepository.findByBusinessName(businessName));
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return this.toCompany(companyJpaRepository.findBySirenNumber(sirenNumber));
    }

    @Override
    public void saveCompany(Company company) {
        companyJpaRepository.save(this.toCompanyJpa(company));
    }

    private Company toCompany(CompanyJpa companyJpa) {
        return new Company(
                companyJpa.getBusinessName(),
                companyJpa.getSirenNumber()
        );
    }

    private CompanyJpa toCompanyJpa(Company company) {
        CompanyJpa companyJpa = new CompanyJpa();
        companyJpa.setBusinessName(company.getBusinessName());
        companyJpa.setSirenNumber(company.getSirenNumber());

        return companyJpa;
    }
}
