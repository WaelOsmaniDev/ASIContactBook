package org.hexavibe.infrastructure.database.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactMongoRepository extends MongoRepository<ContactMongoDB, String> {

    List<ContactMongoDB> findAll();
}
