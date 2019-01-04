package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.use_cases.ContactNotFoundException;

public class ContactJpaNotFoundException extends ContactNotFoundException {

    public ContactJpaNotFoundException(String message) {
        super(message);
    }
}
