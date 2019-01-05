package org.hexavibe.infrastructure.database.nosql;

import org.bson.types.ObjectId;
import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.hexavibe.domain.use_cases.ContactPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("ContactNoSQL")
public class ContactNoSQLPersistence implements ContactPersistencePort {

    private final ContactMongoRepository contactMongoRepository;

    private final CompanyMongoRepository companyMongoRepository;

    public ContactNoSQLPersistence(ContactMongoRepository contactMongoRepository, CompanyMongoRepository companyMongoRepository) {
        this.contactMongoRepository = contactMongoRepository;
        this.companyMongoRepository = companyMongoRepository;
    }

    @Override
    public Contact getContactById(String id) throws ContactMongoDBNotFoundException {
        return ContactMongoAssembler.toContact(
                this.contactMongoRepository
                        .findById(id)
                        .orElseThrow(() -> new ContactMongoDBNotFoundException(
                                String.format("No Contact matching the id: %s, was found", id)))
        );
    }

    @Override
    public Contact updateCompanyOfContact(String id, Company newCompany) throws ContactMongoDBNotFoundException {

        ContactMongoDB contactMongoDB = this.contactMongoRepository
                .findById(id)
                .orElseThrow(() -> new ContactMongoDBNotFoundException(
                        String.format("The contact %s, you want to update is not present"
                                , id)
                ));

        CompanyMongoDB companyMongoDBinDB = this.companyMongoRepository.findBySirenNumber(newCompany.getSirenNumber());

        if (companyMongoDBinDB != null) {
            companyMongoDBinDB.setBusinessName(newCompany.getBusinessName());
            contactMongoDB.setCompanyMongoDB(companyMongoDBinDB);
        } else {
            CompanyMongoDB newCompanyMongoDB = CompanyMongoAssembler.toCompanyMongoDB(newCompany);
            newCompanyMongoDB.set_id(ObjectId.get());

            contactMongoDB.setCompanyMongoDB(newCompanyMongoDB);
        }

        return ContactMongoAssembler.toContact(
                this.contactMongoRepository.save(contactMongoDB));
    }

    @Override
    public Contact saveContact(Contact contact) {

        ContactMongoDB contactMongoDB = ContactMongoAssembler.toContactMongoDB(contact);

        CompanyMongoDB newCompanyMongoDB = CompanyMongoAssembler.toCompanyMongoDB(contact.getCompany());

        CompanyMongoDB companyMongoDBinDB = this.companyMongoRepository.findBySirenNumber(contact.getCompany().getSirenNumber());

        if (companyMongoDBinDB != null) {
            contactMongoDB.setCompanyMongoDB(companyMongoDBinDB);
        } else {
            newCompanyMongoDB.set_id(ObjectId.get());
            contactMongoDB.setCompanyMongoDB(newCompanyMongoDB);
        }

        contactMongoDB.set_id(ObjectId.get());
        return ContactMongoAssembler.toContact(
                this.contactMongoRepository.save(contactMongoDB)
        );
    }

    @Override
    public List<Contact> getAllContacts() {
        return this.contactMongoRepository.findAll()
                .stream()
                .map(ContactMongoAssembler::toContact)
                .collect(Collectors.toList());
    }
}
