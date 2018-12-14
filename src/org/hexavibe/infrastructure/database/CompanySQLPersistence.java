package org.hexavibe.infrastructure.database;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyPersistencePort;

public class CompanySQLPersistence implements CompanyPersistencePort {

    @Override
    public Company getCompanyByBusinessName(String businessName) {
        return null;
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return null;
    }

    @Override
    public void saveCompany(Company company) {

    }
}
