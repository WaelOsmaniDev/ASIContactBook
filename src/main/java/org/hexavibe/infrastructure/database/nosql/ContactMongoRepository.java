package org.hexavibe.infrastructure.database.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactMongoRepository extends MongoRepository<ContactMongoDB, String> {

}
