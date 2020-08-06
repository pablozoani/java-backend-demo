package com.pablozoani.webapp.layers.business.service.base;

import com.pablozoani.webapp.layers.model.base.Person;

import java.util.Set;

public interface PersonService<T extends Person> {

    boolean existsByEmail(String email);

    Set<? extends Person> findAll();

    T findById(Long id);
}
