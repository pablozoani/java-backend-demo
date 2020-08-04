package com.pablozoani.zoop.reusable_entities;

import java.util.Objects;

public class Person {

    private String firstName;

    private String lastName;

    private String email;

    public Person(String firstName, String lastName, String email) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Person = {" +
               "firstName = '" + firstName + '\'' +
               ", lastName = '" + lastName + '\'' +
               ", email = '" + email + '\'' +
               '}';
    }
}
