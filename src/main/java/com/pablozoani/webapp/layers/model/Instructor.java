package com.pablozoani.webapp.layers.model;

import com.pablozoani.webapp.layers.model.base.Person;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Instructor extends Person {


    @OneToMany(mappedBy = "instructor",
               cascade = ALL)
    private Set<Course> courses = new HashSet<>();

    protected Instructor() {

    }

    public Instructor(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Instructor{} " + super.toString();
    }
}
