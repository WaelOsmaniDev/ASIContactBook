package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.domain.use_cases.ContactPersistencePort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContactSQLPersistence implements ContactPersistencePort {

    private final ContactJpaRepository contactJpaRepository;

    private final CompanyJpaRepository companyJpaRepository;

    public ContactSQLPersistence(ContactJpaRepository contactJpaRepository, CompanyJpaRepository companyJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public Contact getContactById(Long id) throws ContactNotFoundException {
        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.findById(id)
                        .orElseThrow(() -> new ContactNotFoundException(String.format("No Contact mathcing the id: %d, was found", id)))
        );
    }

    @Override
    public void updateCompanyOfContact(Long id, Company newCompany) throws ContactNotFoundException {

        ContactJpa contactJpa = this.contactJpaRepository.findById(id).orElseThrow(() -> new ContactNotFoundException("The contact you want to update is not present"));

        contactJpa.setCompanyJpa(CompanyJpaAssembler.toCompanyJpa(newCompany));
        this.contactJpaRepository.save(contactJpa);
    }

    @Override
    public void saveContact(Contact contact) {
        CompanyJpa companyJpa = this.companyJpaRepository.findByBusinessName(contact.getCompany().getBusinessName());
        ContactJpa contactJpa = ContactJpaAssembler.toContactJpa(contact);

        if (companyJpa != null) {
            contactJpa.setCompanyJpa(companyJpa);
        }

        this.contactJpaRepository.save(contactJpa);
    }
}
