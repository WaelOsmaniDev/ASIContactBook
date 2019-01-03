package org.hexavibe.application.rest;

public class CompanyResource {

    private String id;

    private String businessName;

    private String sirenNumber;

    public CompanyResource() {
    }

    public CompanyResource(String id, String businessName, String sirenNumber) {
        this.id = id;
        this.businessName = businessName;
        this.sirenNumber = sirenNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
