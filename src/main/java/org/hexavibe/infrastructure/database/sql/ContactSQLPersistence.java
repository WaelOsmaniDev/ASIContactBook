package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.domain.use_cases.ContactPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class ContactSQLPersistence implements ContactPersistencePort {

    private final ContactJpaRepository contactJpaRepository;

    private final CompanyJpaRepository companyJpaRepository;

    public ContactSQLPersistence(ContactJpaRepository contactJpaRepository, CompanyJpaRepository companyJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public Contact getContactById(String id) throws ContactNotFoundException {
        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.findById(id)
                        .orElseThrow(() -> new ContactNotFoundException(String.format("No Contact matching the id: %d, was found", id)))
        );
    }

    @Override
    public Contact updateCompanyOfContact(String id, Company newCompany) throws ContactNotFoundException {

        ContactJpa contactJpa = this.contactJpaRepository.findById(id).orElseThrow(() -> new ContactNotFoundException("The contact you want to update is not present"));

        contactJpa.setCompanyJpa(CompanyJpaAssembler.toCompanyJpa(newCompany));

        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.save(contactJpa)
        );
    }

    @Override
    public Contact saveContact(Contact contact) {
        CompanyJpa companyJpa = this.companyJpaRepository.findByBusinessName(contact.getCompany().getBusinessName());
        ContactJpa contactJpa = ContactJpaAssembler.toContactJpa(contact);

        if (companyJpa != null) {
            contactJpa.setCompanyJpa(companyJpa);
        }

        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.save(contactJpa)
        );
    }
}
