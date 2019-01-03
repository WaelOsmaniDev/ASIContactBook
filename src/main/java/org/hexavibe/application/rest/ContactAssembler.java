package org.hexavibe.application.rest;

import org.hexavibe.domain.entities.Contact;

public class ContactAssembler {

    public static ContactResource toResource(Contact contact) {
        ContactResource contactResource = new ContactResource();
        contactResource.setId(contact.getId());
        contactResource.setFirstName(contact.getFirstName());
        contactResource.setLastName(contact.getLastName());
        contactResource.setBirthdate(contact.getBirthdate());
        contactResource.setPromo(contact.getPromo());
        contactResource.setCompany(CompanyAssembler.toResource(contact.getCompany()));

        return contactResource;
    }

    public static Contact toEntity(ContactResource contactResource) {
        return new Contact(
                contactResource.getFirstName(),
                contactResource.getLastName(),
                contactResource.getBirthdate(),
                contactResource.getPromo(),
                CompanyAssembler.toEntity(contactResource.getCompany())
        );
    }
}
