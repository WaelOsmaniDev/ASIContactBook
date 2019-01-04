package org.hexavibe.infrastructure.database.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyMongoRepository extends MongoRepository<CompanyMongoDB, String> {

    CompanyMongoDB findByBusinessName(String businessName);

    CompanyMongoDB findBySirenNumber(String sirenNumber);
}
