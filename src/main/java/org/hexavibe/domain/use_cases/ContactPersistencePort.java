package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.infrastructure.database.sql.ContactNotFoundException;

public interface ContactPersistencePort {

    Contact getContactById(Long id) throws ContactNotFoundException;

    void updateCompanyOfContact(Long id, Company newCompany) throws ContactNotFoundException;

    void saveContact(Contact contact);
}
