package org.hexavibe.application.rest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ContactResource {

    private Long id;
    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String promo;


    private CompanyResource company;

    public ContactResource() {
    }

    public ContactResource(Long id, String firstName, String lastName, LocalDate birthdate, String promo, CompanyResource company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.promo = promo;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public CompanyResource getCompany() {
        return company;
    }

    public void setCompany(CompanyResource company) {
        this.company = company;
    }
}
