package com.pablozoani.webapp.layers.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pablozoani.webapp.layers.model.base.BaseEntity;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Course extends BaseEntity {

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FieldOfStudy field;

    @Getter
    @Setter
    @JsonManagedReference
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @Getter
    @Setter
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;

    @Getter
    @ManyToMany(fetch = LAZY, mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    protected Course() { }

    public Course(String title, FieldOfStudy field, Instructor instructor, Academy academy) {

        this.title = title;

        this.field = field;

        this.instructor = instructor;

        this.academy = academy;
    }

    @PreRemove
    private void removeAllStudents() { getStudents().forEach(student -> student.removeCourse(this)); }

    public void addStudent(@NotNull Student student) {

        getStudents().add(student);

        student.getCourses().add(this);
    }

    public void removeStudent(@NotNull Student student) {

        getStudents().remove(student);

        student.getCourses().remove(this);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        return getTitle().equals(course.getTitle()) &&
                getInstructor().equals(course.getInstructor()) &&
                getAcademy().equals(course.getAcademy());
    }

    @Override
    public int hashCode() {

        int output = 0;

        output += getTitle().hashCode();

        output += getInstructor().hashCode();

        output += getAcademy().hashCode();

        return output;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", field=" + field +
                "} " + super.toString();
    }
}
