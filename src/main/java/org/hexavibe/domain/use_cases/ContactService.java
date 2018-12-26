package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;

public class ContactService {

    private ContactPersistencePort contactPersistencePort;

    public ContactService(ContactPersistencePort contactPersistencePort) {
        this.contactPersistencePort = contactPersistencePort;
    }

    private Contact getContactById(int id) {
        return this.contactPersistencePort.getContactById(id);
    }

    private void updateCompanyOfContact(Contact contact, Company newCompany) {
        this.contactPersistencePort.updateCompanyOfContact(contact, newCompany);
    }

    private void saveContact(Contact contact) {
        this.contactPersistencePort.saveContact(contact);
    }
}
