package org.hexavibe.application.rest;

public class CompanyApi {

    private String id;

    private String businessName;

    private String sirenNumber;

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
