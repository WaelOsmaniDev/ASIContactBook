package org.hexavibe.application.rest;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.use_cases.CompanyAppPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyAppPort companyAppPort;

    public CompanyController(CompanyAppPort companyAppPort) {
        this.companyAppPort = companyAppPort;
    }

    @GetMapping
    public CompanyApi getCompanyByBusinessName(@RequestParam(name = "businessName", required = false) String businessName) {
        return this.toCompanyApi(companyAppPort.getCompanyByBusinessName(businessName));
    }

    private CompanyApi toCompanyApi(Company company) {
        CompanyApi companyApi = new CompanyApi();

        companyApi.setBusinessName(company.getBusinessName());
        companyApi.setSirenNumber(company.getSirenNumber());

        return companyApi;
    }
}
