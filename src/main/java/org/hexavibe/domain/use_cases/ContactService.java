package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.infrastructure.database.sql.ContactNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ContactService implements ContactAppPort {

    private ContactPersistencePort contactPersistencePort;

    public ContactService(ContactPersistencePort contactPersistencePort) {
        this.contactPersistencePort = contactPersistencePort;
    }

    @Override
    public Contact getContactById(Long id) {
        try {
            return this.contactPersistencePort.getContactById(id);
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCompanyOfContact(Long id, Company newCompany) {
        try {
            this.contactPersistencePort.updateCompanyOfContact(id, newCompany);
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveContact(Contact contact) {
        this.contactPersistencePort.saveContact(contact);
    }
}
