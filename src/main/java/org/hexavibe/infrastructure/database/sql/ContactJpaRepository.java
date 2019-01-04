package org.hexavibe.infrastructure.database.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContactJpaRepository extends JpaRepository<ContactJpa, String> {

    List<ContactJpa> findAll();

    Optional<ContactJpa> findContactJpaByFirstNameAndLastNameAndAndBirthdate(
            String firstName, String lastName, LocalDate birthdate
    );

}
