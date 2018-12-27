package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;

public interface ContactPersistencePort {

    Contact getContactById(int id);

    void updateCompanyOfContact(Contact contact, Company newCompany);

    void saveContact(Contact contact);
}
