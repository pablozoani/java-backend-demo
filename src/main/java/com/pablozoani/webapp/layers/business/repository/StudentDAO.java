package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.business.repository.base.PersonDAO;
import com.pablozoani.webapp.layers.model.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile({"default", "dev", "prod"})
@Repository
public interface StudentDAO
        extends CrudRepository<Student, Long>, PersonDAO<Student, Long> {

}
