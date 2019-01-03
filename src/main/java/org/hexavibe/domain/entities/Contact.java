package org.hexavibe.domain.entities;

import java.time.LocalDate;

public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String promo;
    private Company company;

    public Contact(String id, String firstName, String lastName, LocalDate birthdate, String promo, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.promo = promo;
        this.company = company;
    }

    public Contact(String firstName, String lastName, LocalDate birthdate, String promo, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.promo = promo;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
