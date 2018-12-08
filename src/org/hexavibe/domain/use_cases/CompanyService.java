package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;

public class CompanyService {

    private CompanyPersistencePort companyPersistencePort;

    private Company getCompanyByBusinessName(String businessName) {
        return companyPersistencePort.getCompanyByBusinessName(businessName);
    }
}
