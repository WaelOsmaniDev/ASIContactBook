package org.hexavibe.infrastructure.database.sql;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class ContactJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    private LocalDate birthdate;
    private String promo;

    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyJpa companyJpa;

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

    public CompanyJpa getCompanyJpa() {
        return companyJpa;
    }

    public void setCompanyJpa(CompanyJpa companyJpa) {
        this.companyJpa = companyJpa;
    }
}
