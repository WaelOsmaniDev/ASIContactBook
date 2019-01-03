package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;

public interface ContactAppPort {

    Contact getContactById(Long id);

    void updateCompanyOfContact(Long id, Company newCompany);

    void saveContact(Contact contact);
}
