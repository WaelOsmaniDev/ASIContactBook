package org.hexavibe.infrastructure.database.nosql;

import org.bson.types.ObjectId;
import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyPersistencePort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyNoSQLPersistence implements CompanyPersistencePort {

    private final CompanyMongoRepository companyMongoRepository;

    public CompanyNoSQLPersistence(CompanyMongoRepository companyMongoRepository) {
        this.companyMongoRepository = companyMongoRepository;
    }


    @Override
    public Company getCompanyByBusinessName(String businessName) {
        return CompanyMongoAssembler.toCompany(this.companyMongoRepository.findByBusinessName(businessName));
    }

    @Override
    public Company getCompanyBySirenNumber(String sirenNumber) {
        return CompanyMongoAssembler.toCompany(this.companyMongoRepository.findBySirenNumber(sirenNumber));
    }

    @Override
    public Company saveCompany(Company company) {
        CompanyMongoDB companyMongoDBInDB = this.companyMongoRepository.findBySirenNumber(company.getSirenNumber());

        if (companyMongoDBInDB != null) {
            return CompanyMongoAssembler.toCompany(companyMongoDBInDB);
        } else {

            CompanyMongoDB companyMongoDB = CompanyMongoAssembler.toCompanyMongoDB(company);
            companyMongoDB.set_id(ObjectId.get());
            return CompanyMongoAssembler.toCompany(this.companyMongoRepository
                    .save(companyMongoDB));
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyMongoRepository.findAll()
                .stream()
                .map(CompanyMongoAssembler::toCompany)
                .collect(Collectors.toList());
    }
}
