package com.pablozoani.webapp.layers.model;

import com.pablozoani.webapp.layers.model.base.Person;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Student extends Person {

    @Getter
    @ManyToMany(fetch = LAZY, mappedBy = "students",
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Course> courses = new HashSet<>();

    protected Student() {

    }

    public Student(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public void addCourse(@NotNull Course course) {
        course.addStudent(this);
    }

    public void removeStudent(@NotNull Course course) {
        course.removeStudent(this);
    }

    @Override
    public String toString() {
        return "Student{} " + super.toString();
    }
}
