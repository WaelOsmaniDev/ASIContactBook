package org.hexavibe.infrastructure.database.nosql;

import org.bson.types.ObjectId;
import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyPersistencePort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CompanyNoSQLPersistence implements CompanyPersistencePort {

    private final CompanyMongoRepository companyMongoRepository;

    public CompanyNoSQLPersistence(CompanyMongoRepository companyMongoRepository) {
        this.companyMongoRepository = companyMongoRepository;
    }


    @Override
    public Company getCompanyByBusinessName(String businessName) {
        return CompanyNoSQLAssembler.toCompany(this.companyMongoRepository.findByBusinessName(businessName));
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return CompanyNoSQLAssembler.toCompany(this.companyMongoRepository.findBySirenNumber(sirenNumber));
    }

    @Override
    public Company saveCompany(Company company) {
        CompanyNoSQL companyNoSQL = CompanyNoSQLAssembler.toCompanyNoSQL(company);
        companyNoSQL.set_id(ObjectId.get());
        return CompanyNoSQLAssembler.toCompany(this.companyMongoRepository
                .save(companyNoSQL));
    }
}
