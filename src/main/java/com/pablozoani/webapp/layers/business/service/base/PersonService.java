package com.pablozoani.webapp.layers.business.service.base;

import com.pablozoani.webapp.layers.model.base.Person;

import java.util.Set;

public interface PersonService<T extends Person> {

    /**
     * Find all persons in the database.
     *
     * @return a Set with the persons
     */
    Set<T> findAll();

    /**
     * Retrieves a person by its id.
     *
     * @param id of the person
     * @return a person if its found
     * @throws IllegalArgumentException if param
     * is null
     */
    T findById(Long id);
}
