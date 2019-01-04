package org.hexavibe.infrastructure.database.nosql;

import org.hexavibe.domain.entities.Contact;

public final class ContactMongoAssembler {

    private ContactMongoAssembler() {
    }

    public static Contact toContact(ContactMongoDB contactMongoDB) {
        return new Contact(
                contactMongoDB.get_id(),
                contactMongoDB.getFirstName(),
                contactMongoDB.getLastName(),
                contactMongoDB.getBirthdate(),
                contactMongoDB.getPromo(),
                CompanyMongoAssembler.toCompany(contactMongoDB.getCompanyMongoDB())
        );
    }

    public static ContactMongoDB toContactMongoDB(Contact contact) {
        ContactMongoDB contactMongoDB = new ContactMongoDB();
        contactMongoDB.setFirstName(contact.getFirstName());
        contactMongoDB.setLastName(contact.getLastName());
        contactMongoDB.setBirthdate(contact.getBirthdate());
        contactMongoDB.setPromo(contact.getPromo());
        contactMongoDB.setCompanyMongoDB(
                CompanyMongoAssembler.toCompanyMongoDB(contact.getCompany())
        );

        return contactMongoDB;
    }
}
