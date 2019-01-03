package org.hexavibe.infrastructure.database.nosql;

import org.hexavibe.domain.entities.Company;

public final class CompanyNoSQLAssembler {

    public CompanyNoSQLAssembler() {
    }

    public static Company toCompany(CompanyNoSQL companyNoSQL) {
        return new Company(
                companyNoSQL.get_id(),
                companyNoSQL.getBusinessName(),
                companyNoSQL.getSirenNumber()
        );
    }

    public static CompanyNoSQL toCompanyNoSQL(Company company) {
        CompanyNoSQL companyNoSQL = new CompanyNoSQL();
        companyNoSQL.setBusinessName(company.getBusinessName());
        companyNoSQL.setSirenNumber(company.getSirenNumber());

        return companyNoSQL;
    }
}
