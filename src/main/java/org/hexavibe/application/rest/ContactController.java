package org.hexavibe.application.rest;

import org.hexavibe.domain.use_cases.ContactAppPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactAppPort contactAppPort;

    public ContactController(ContactAppPort contactAppPort) {
        this.contactAppPort = contactAppPort;
    }

    @GetMapping("/{id}")
    public ContactResource getCompanyById(@PathVariable Long id) {
        return ContactAssembler.toResource(contactAppPort.getContactById(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addContact(@RequestBody ContactResource contactResource) {

        this.contactAppPort.saveContact(ContactAssembler.toEntity(contactResource));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/company")
    public ResponseEntity updateCompanyOfContact(@PathVariable Long id, @RequestBody CompanyResource newCompany) {

        this.contactAppPort.updateCompanyOfContact(id, CompanyAssembler.toEntity(newCompany));

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
