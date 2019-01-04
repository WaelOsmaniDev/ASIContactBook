package org.hexavibe.infrastructure.database.nosql;

import org.hexavibe.domain.entities.Company;

public final class CompanyMongoAssembler {

    public CompanyMongoAssembler() {
    }

    public static Company toCompany(CompanyMongoDB companyMongoDB) {
        return new Company(
                companyMongoDB.get_id(),
                companyMongoDB.getBusinessName(),
                companyMongoDB.getSirenNumber()
        );
    }

    public static CompanyMongoDB toCompanyMongoDB(Company company) {
        CompanyMongoDB companyMongoDB = new CompanyMongoDB();
        companyMongoDB.setBusinessName(company.getBusinessName());
        companyMongoDB.setSirenNumber(company.getSirenNumber());

        return companyMongoDB;
    }
}
