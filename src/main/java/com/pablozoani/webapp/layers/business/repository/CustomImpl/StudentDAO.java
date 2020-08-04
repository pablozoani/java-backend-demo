package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.business.repository.CustomImpl.base.PersonDAO;
import com.pablozoani.webapp.layers.model.Student;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StudentDAO extends PersonDAO<Student, Long> {

}
