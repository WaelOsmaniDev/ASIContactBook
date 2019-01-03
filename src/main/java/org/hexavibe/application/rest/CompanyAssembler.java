package org.hexavibe.application.rest;

import org.hexavibe.domain.entities.Company;

public final class CompanyAssembler {

    public CompanyAssembler() {
    }

    public static CompanyResource toResource(Company company) {
        CompanyResource companyResource = new CompanyResource();

        companyResource.setBusinessName(company.getBusinessName());
        companyResource.setSirenNumber(company.getSirenNumber());
        companyResource.setId(company.getId());

        return companyResource;
    }

    public static Company toEntity(CompanyResource companyResource) {
        return new Company(companyResource.getBusinessName(), companyResource.getSirenNumber());
    }
}
