package com.pablozoani.webapp.layers.model;

import com.pablozoani.webapp.layers.model.base.Person;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Student extends Person {

    @Getter
    @ManyToMany(fetch = LAZY)
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    protected Student() { }

    public Student(String firstName, String lastName, String email) { super(firstName, lastName, email); }

    public void addCourse(@NotNull Course course) {

        courses.add(course);

        course.addStudent(this);
    }

    void removeCourse(@NotNull Course course) { courses.remove(course); }

    @Override
    public String toString() { return "Student{} " + super.toString(); }
}
