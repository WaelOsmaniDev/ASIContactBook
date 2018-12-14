package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;

public class CompanyService {

    private CompanyPersistencePort companyPersistencePort;

    public CompanyService(CompanyPersistencePort companyPersistencePort) {
        this.companyPersistencePort = companyPersistencePort;
    }

    private Company getCompanyByBusinessName(String businessName) {
        return this.companyPersistencePort.getCompanyByBusinessName(businessName);
    }

    private Company getCompanyBySirenNumber(String sirenNumber) {
        return this.companyPersistencePort.getCompanyBySirenNumber(sirenNumber);
    }

    private void saveCompany(Company company) {
        this.companyPersistencePort.saveCompany(company);
    }
}
