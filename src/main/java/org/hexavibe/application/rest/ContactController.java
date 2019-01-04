package org.hexavibe.application.rest;

import org.hexavibe.domain.use_cases.ContactAppPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactAppPort contactAppPort;

    public ContactController(ContactAppPort contactAppPort) {
        this.contactAppPort = contactAppPort;
    }

    @GetMapping("/{id}")
    public ContactResource getCompanyById(@PathVariable String id) {
        return ContactAssembler.toResource(contactAppPort.getContactById(id));
    }

    @GetMapping
    public List<ContactResource> getAllContacts() {
        return this.contactAppPort.getAllContacts()
                .stream()
                .map(ContactAssembler::toResource)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ContactResource addContact(@RequestBody ContactResource contactResource) {

        return ContactAssembler.toResource(
                this.contactAppPort.saveContact(ContactAssembler.toEntity(contactResource))
        );
    }

    @PutMapping("/{id}/company")
    public ContactResource updateCompanyOfContact(@PathVariable String id, @RequestBody CompanyResource newCompany) {

        return ContactAssembler.toResource(
                this.contactAppPort.updateCompanyOfContact(id, CompanyAssembler.toEntity(newCompany))
        );
    }

}
