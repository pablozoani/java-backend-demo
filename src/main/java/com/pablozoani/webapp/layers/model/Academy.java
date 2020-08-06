package com.pablozoani.webapp.layers.model;

import com.pablozoani.webapp.layers.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Academy extends BaseEntity {

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String name;

    @Getter
    @OneToMany(fetch = LAZY, mappedBy = "academy", cascade = REMOVE)
    private Set<Course> courses = new HashSet<>();

    protected Academy() {

    }

    public Academy(String name) {
        this.name = name;
    }

    public void addCourse(@NotNull Course course) {

        courses.add(course);

        course.setAcademy(this);
    }

    public void removeCourse(@NotNull Course course) {

        courses.remove(course);

        course.setAcademy(null);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Academy)) return false;

        return getName().equals(((Academy) o).getName());
    }

    @Override
    public int hashCode() { return getName().hashCode(); }

    @Override
    public String toString() {
        return "Academy{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
