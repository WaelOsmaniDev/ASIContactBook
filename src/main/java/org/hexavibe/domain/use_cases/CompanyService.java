package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService implements CompanyAppPort {

    private CompanyPersistencePort companyPersistencePort;

    public CompanyService(@Qualifier("CompanySQL") CompanyPersistencePort companyPersistencePort) {
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
    public Company saveCompany(Company company) {
        return this.companyPersistencePort.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyPersistencePort.getAllCompanies();
    }
}
