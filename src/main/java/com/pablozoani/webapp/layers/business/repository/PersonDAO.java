package com.pablozoani.webapp.layers.business.repository;

import java.time.LocalDate;

public interface PersonDAO<T, ID> {

    Iterable<T> findByRegistrationDateBetween(LocalDate date1, LocalDate date2);

    Iterable<T> findByRegistrationDateGreaterThanEqual(LocalDate date);

    Iterable<T> findByRegistrationDateLessThanEqual(LocalDate date);
}
