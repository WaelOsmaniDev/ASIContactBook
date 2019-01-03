package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;

public final class CompanyJpaAssembler {

    public CompanyJpaAssembler() {
    }

    public static Company toCompany(CompanyJpa companyJpa) {
        return new Company(
                companyJpa.getId(),
                companyJpa.getBusinessName(),
                companyJpa.getSirenNumber()
        );
    }

    public static CompanyJpa toCompanyJpa(Company company) {
        CompanyJpa companyJpa = new CompanyJpa();
        companyJpa.setBusinessName(company.getBusinessName());
        companyJpa.setSirenNumber(company.getSirenNumber());

        return companyJpa;
    }
}
