package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.model.Academy;

import java.util.Set;

public interface AcademyService {

    /**
     * Save the specified data transfer object into the database.
     *
     * @param dto to be saved
     * @return saved object
     */
    AcademyDTO saveAcademy(AcademyDTO dto);

    /**
     * Find an academy with the specified id.
     *
     * @param id to find
     * @return the academy object
     */
    Academy findById(Long id);

    /**
     * Find all the academies containing the specified string
     * in their names.
     *
     * @param name the string to search for
     * @return the matching results
     */
    Set<Academy> findByNameContaining(String name);

    /**
     * Retrieve all the academies in the database.
     *
     * @return a set with the academies
     */
    Set<Academy> findAll();

    /**
     * Delete an academy with the specified id.
     *
     * @param id
     */
    void deleteById(Long id);
}
