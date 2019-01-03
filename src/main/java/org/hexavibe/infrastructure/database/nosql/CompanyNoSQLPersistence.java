//package org.hexavibe.infrastructure.database.nosql;
//
//import org.hexavibe.domain.entities.Company;
//import org.hexavibe.domain.use_cases.CompanyPersistencePort;
//
//public class CompanyNoSQLPersistence implements CompanyPersistencePort {
//
//    private final CompanyMongoRepository companyMongoRepository;
//
//    public CompanyNoSQLPersistence(CompanyMongoRepository companyMongoRepository) {
//        this.companyMongoRepository = companyMongoRepository;
//    }
//
//
//    @Override
//    public Company getCompanyByBusinessName(String businessName) {
//        return this.toCompany(this.companyMongoRepository.findByBusinessName(businessName));
//    }
//
//    @Override
//    public Company getCompanyBySirenNumber(String sirenNumber) {
//        return this.toCompany(this.companyMongoRepository.findBySirenNumber(sirenNumber));
//    }
//
//    @Override
//    public void saveCompany(Company company) {
//        this.companyMongoRepository.save(this.toCompanyNoSQL(company));
//    }
//
//    private Company toCompany(CompanyNoSQL companyNoSQL) {
//        return new Company(
//                companyNoSQL.getId(),
//                companyNoSQL.getBusinessName(),
//                companyNoSQL.getSirenNumber()
//        );
//    }
//
//    private CompanyNoSQL toCompanyNoSQL(Company company) {
//        CompanyNoSQL companyNoSQL = new CompanyNoSQL();
//        companyNoSQL.setBusinessName(company.getBusinessName());
//        companyNoSQL.setSirenNumber(company.getSirenNumber());
//
//        return companyNoSQL;
//    }
//}
