package com.pablozoani.webapp.layers.model.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Getter
    @CreationTimestamp
    private LocalDate registrationDate;

    protected Person() {

    }

    public Person(String firstName, String lastName, String email) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Person)) return false;

        return getEmail().equals(((Person) o).getEmail());
    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", birthDate=" + dateOfBirth +
               "} " + super.toString();
    }
}
