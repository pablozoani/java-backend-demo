package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.PersonDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface InstructorDAO extends PersonDAO<Instructor, Long> {

}
