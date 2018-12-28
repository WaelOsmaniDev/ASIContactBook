package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyService implements CompanyAppPort {

    private CompanyPersistencePort companyPersistencePort;

    public CompanyService(CompanyPersistencePort companyPersistencePort) {
        this.companyPersistencePort = companyPersistencePort;
    }

    @Override
    public Company getCompanyByBusinessName(String businessName) {
        return this.companyPersistencePort.getCompanyByBusinessName(businessName);
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return this.companyPersistencePort.getCompanyBySirenNumber(sirenNumber);
    }

    @Override
    public void saveCompany(Company company) {
        this.companyPersistencePort.saveCompany(company);
    }
}
