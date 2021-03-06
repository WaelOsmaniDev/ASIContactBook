package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;

import java.util.List;

public interface ContactPersistencePort {

    Contact getContactById(String id) throws ContactNotFoundException;

    Contact updateCompanyOfContact(String id, Company newCompany) throws ContactNotFoundException;

    Contact saveContact(Contact contact);

    List<Contact> getAllContacts();

}
