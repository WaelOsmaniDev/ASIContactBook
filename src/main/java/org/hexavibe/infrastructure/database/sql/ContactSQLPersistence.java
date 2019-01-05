package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.domain.use_cases.ContactPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("ContactSQL")
public class ContactSQLPersistence implements ContactPersistencePort {

    private final ContactJpaRepository contactJpaRepository;

    private final CompanyJpaRepository companyJpaRepository;

    public ContactSQLPersistence(ContactJpaRepository contactJpaRepository, CompanyJpaRepository companyJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public Contact getContactById(String id) throws ContactJpaNotFoundException {
        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.findById(id)
                        .orElseThrow(() -> new ContactJpaNotFoundException(String.format("No Contact matching the id: %s, was found", id)))
        );
    }

    @Override
    public Contact updateCompanyOfContact(String id, Company newCompany) throws ContactJpaNotFoundException {

        ContactJpa contactJpa = this.contactJpaRepository.findById(id).orElseThrow(() -> new ContactJpaNotFoundException(
                String.format("The contact %s, you want to update is not present"
                        , id)));

        CompanyJpa companyJpaInDB = this.companyJpaRepository.findBySirenNumber(newCompany.getSirenNumber());

        if (companyJpaInDB != null) {
            companyJpaInDB.setBusinessName(newCompany.getBusinessName());
            contactJpa.setCompanyJpa(companyJpaInDB);
        } else {
            contactJpa.setCompanyJpa(CompanyJpaAssembler.toCompanyJpa(newCompany));
        }


        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.save(contactJpa)
        );
    }

    @Override
    public Contact saveContact(Contact contact) {
        ContactJpa contactJpa = this.contactJpaRepository.findContactJpaByFirstNameAndLastNameAndAndBirthdate(
                contact.getFirstName(), contact.getLastName(), contact.getBirthdate()
        ).orElse(ContactJpaAssembler.toContactJpa(contact));

        CompanyJpa companyJpaInDB = this.companyJpaRepository.findBySirenNumber(contact.getCompany().getSirenNumber());

        if (companyJpaInDB != null) {
            contactJpa.setCompanyJpa(companyJpaInDB);
        }

        return ContactJpaAssembler.toContact(
                this.contactJpaRepository.save(contactJpa)
        );
    }

    @Override
    public List<Contact> getAllContacts() {
        return this.contactJpaRepository.findAll()
                .stream()
                .map(ContactJpaAssembler::toContact)
                .collect(Collectors.toList());
    }
}
