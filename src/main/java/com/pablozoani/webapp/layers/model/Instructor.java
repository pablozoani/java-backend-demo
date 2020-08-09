package com.pablozoani.webapp.layers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pablozoani.webapp.layers.model.base.Person;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Instructor extends Person {

    @JsonBackReference
    @OneToMany(fetch = LAZY, mappedBy = "instructor", cascade = REMOVE)
    private Set<Course> courses = new HashSet<>();

    protected Instructor() { }

    public Instructor(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public void addCourse(@NotNull Course course) {

        courses.add(course);

        course.setInstructor(this);
    }

    public void removeCourse(@NotNull Course course) {

        courses.remove(course);

        course.setInstructor(null);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() { return "Instructor{} " + super.toString(); }
}
