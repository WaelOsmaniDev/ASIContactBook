package org.hexavibe.infrastructure.database.nosql;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "contacts")
public class ContactMongoDB {

    @Id
    public ObjectId _id;

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String promo;

    private CompanyMongoDB companyMongoDB;

    public ContactMongoDB() {
    }

    public ContactMongoDB(ObjectId _id, String firstName, String lastName, LocalDate birthdate, String promo, CompanyMongoDB companyMongoDB) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.promo = promo;
        this.companyMongoDB = companyMongoDB;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public CompanyMongoDB getCompanyMongoDB() {
        return companyMongoDB;
    }

    public void setCompanyMongoDB(CompanyMongoDB companyMongoDB) {
        this.companyMongoDB = companyMongoDB;
    }
}
