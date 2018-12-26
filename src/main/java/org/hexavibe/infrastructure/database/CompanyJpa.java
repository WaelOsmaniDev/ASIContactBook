package org.hexavibe.infrastructure.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyJpa {

    @Id
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
