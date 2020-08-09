package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.service.base.PersonService;
import com.pablozoani.webapp.layers.model.Instructor;

public interface InstructorService extends PersonService<Instructor> {

    /**
     * Save an instructor DTO into the database.
     *
     * @param instructorDTO to be saved
     * @return the saved instructor dto
     * @throws IllegalArgumentException if parameter is
     * null
     */
    InstructorDTO saveInstructor(InstructorDTO instructorDTO);

    void deleteInstructorById(Long id);

    InstructorDTO findDtoById(Long id);
}
