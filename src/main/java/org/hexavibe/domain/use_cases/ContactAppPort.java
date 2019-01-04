package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;

import java.util.List;

public interface ContactAppPort {

    Contact getContactById(String id);

    Contact updateCompanyOfContact(String id, Company newCompany);

    Contact saveContact(Contact contact);

    List<Contact> getAllContacts();
}
