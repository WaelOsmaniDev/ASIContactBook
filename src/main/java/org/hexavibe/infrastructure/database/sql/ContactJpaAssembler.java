package org.hexavibe.infrastructure.database.sql;

import org.hexavibe.domain.entities.Contact;

public final class ContactJpaAssembler {

    public ContactJpaAssembler() {
    }

    public static Contact toContact(ContactJpa contactJpa) {
        return new Contact(
                contactJpa.getId(),
                contactJpa.getFirstName(),
                contactJpa.getLastName(),
                contactJpa.getBirthdate(),
                contactJpa.getPromo(),
                CompanyJpaAssembler.toCompany(contactJpa.getCompanyJpa())
        );
    }

    public static ContactJpa toContactJpa(Contact contact) {
        ContactJpa contactJpa = new ContactJpa();
        contactJpa.setFirstName(contact.getFirstName());
        contactJpa.setLastName(contact.getLastName());
        contactJpa.setBirthdate(contact.getBirthdate());
        contactJpa.setPromo(contact.getPromo());
        contactJpa.setCompanyJpa(
                CompanyJpaAssembler.toCompanyJpa(contact.getCompany())
        );

        return contactJpa;
    }
}
