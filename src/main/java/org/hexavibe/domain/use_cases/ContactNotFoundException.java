package org.hexavibe.domain.use_cases;

public class ContactNotFoundException extends Exception {

    public ContactNotFoundException(String message) {
        super(message);
    }
}
