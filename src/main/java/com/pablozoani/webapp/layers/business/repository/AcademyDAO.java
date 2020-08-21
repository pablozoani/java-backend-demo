package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.model.Academy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile({"default", "dev", "prod"})
@Repository
public interface AcademyDAO extends CrudRepository<Academy, Long> {

    boolean existsByName(String name);

    Iterable<Academy> findByNameContainingIgnoreCase(String name);
}
