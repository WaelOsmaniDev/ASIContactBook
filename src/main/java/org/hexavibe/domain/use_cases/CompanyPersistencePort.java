package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;

public interface CompanyPersistencePort {

    Company getCompanyByBusinessName(String businessName);

    Company getCompanyBySirenNumber(String sirenNumber);

    Company saveCompany(Company company);
}
