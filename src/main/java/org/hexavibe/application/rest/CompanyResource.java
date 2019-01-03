package org.hexavibe.application.rest;

public class CompanyResource {

    private Long id;

    private String businessName;

    private String sirenNumber;

    public CompanyResource() {
    }

    public CompanyResource(Long id, String businessName, String sirenNumber) {
        this.id = id;
        this.businessName = businessName;
        this.sirenNumber = sirenNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSirenNumber() {
        return sirenNumber;
    }

    public void setSirenNumber(String sirenNumber) {
        this.sirenNumber = sirenNumber;
    }
}
