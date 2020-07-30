package com.pablozoani.webapp.layers.business.repository.CustomImpl;

import com.pablozoani.webapp.layers.model.Academy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AcademyDAO extends CrudRepository<Academy, Long> {

}
