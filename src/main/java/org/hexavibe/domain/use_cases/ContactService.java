package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ContactService implements ContactAppPort {

    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    private ContactPersistencePort contactPersistencePort;

    public ContactService(ContactPersistencePort contactPersistencePort) {
        this.contactPersistencePort = contactPersistencePort;
    }

    @Override
    public Contact getContactById(String id) {
        try {
            return this.contactPersistencePort.getContactById(id);
        } catch (ContactNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public Contact updateCompanyOfContact(String id, Company newCompany) {
        try {
            return this.contactPersistencePort.updateCompanyOfContact(id, newCompany);
        } catch (ContactNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return this.contactPersistencePort.saveContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return this.contactPersistencePort.getAllContacts();
    }
}
