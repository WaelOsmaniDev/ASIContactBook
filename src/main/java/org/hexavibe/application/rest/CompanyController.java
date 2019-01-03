package org.hexavibe.application.rest;

import org.hexavibe.domain.use_cases.CompanyAppPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyAppPort companyAppPort;

    public CompanyController(CompanyAppPort companyAppPort) {
        this.companyAppPort = companyAppPort;
    }

    @GetMapping(params = "businessName")
    public CompanyResource getCompanyByBusinessName(@RequestParam(name = "businessName") String businessName) {
        return CompanyAssembler.toResource(companyAppPort.getCompanyByBusinessName(businessName));
    }

    @GetMapping(params = "sirenNumber")
    public CompanyResource getCompanyBySirenNumber(
            @RequestParam(name = "sirenNumber") String sirenNumber) {
        return CompanyAssembler.toResource(
                companyAppPort.getCompanyBySirenNumber(sirenNumber));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addCompany(@RequestBody CompanyResource companyResource) {
        companyAppPort.saveCompany(CompanyAssembler.toEntity(companyResource));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
