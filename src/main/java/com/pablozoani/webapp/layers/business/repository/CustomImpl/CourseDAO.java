package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CourseDAO extends CrudRepository<Course, Long> {

    Iterable<Course> findByField(FieldOfStudy field);
}
