package org.hexavibe.domain.entities;

public class Company {

    private String businessName;
    private String sirenNumber;

    public Company(String businessName, String sirenNumber) {
        this.businessName = businessName;
        this.sirenNumber = sirenNumber;
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
