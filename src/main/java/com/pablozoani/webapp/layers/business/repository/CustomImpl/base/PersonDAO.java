package com.pablozoani.webapp.layers.business.repository.CustomImpl.base;

import com.pablozoani.webapp.layers.model.base.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;

@NoRepositoryBean
public interface PersonDAO<T extends Person, ID> extends CrudRepository<T, ID> {

    Iterable<T> findByRegistrationDateBetween(LocalDate date1, LocalDate date2);

    Iterable<T> findByRegistrationDateGreaterThanEqual(LocalDate date);

    Iterable<T> findByRegistrationDateLessThanEqual(LocalDate date);
}
