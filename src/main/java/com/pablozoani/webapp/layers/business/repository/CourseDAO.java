package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("default")
@Repository
public interface CourseDAO extends CrudRepository<Course, Long> {

    Iterable<Course> findByField(FieldOfStudy field);
}
