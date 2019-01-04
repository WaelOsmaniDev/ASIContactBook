package org.hexavibe.infrastructure.database.nosql;

import org.hexavibe.domain.use_cases.ContactNotFoundException;

public class ContactMongoDBNotFoundException extends ContactNotFoundException {

    public ContactMongoDBNotFoundException(String message) {
        super(message);
    }
}
