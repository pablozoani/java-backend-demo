package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.business.repository.base.PersonDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("default")
@Repository
public interface InstructorDAO
        extends CrudRepository<Instructor, Long>, PersonDAO<Instructor, Long> {

}
