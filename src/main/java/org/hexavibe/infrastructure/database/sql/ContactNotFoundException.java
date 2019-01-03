package org.hexavibe.infrastructure.database.sql;

public class ContactNotFoundException extends Exception {

    public ContactNotFoundException(String message) {
        super(message);
    }
}
