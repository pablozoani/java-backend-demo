package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.service.base.PersonService;
import com.pablozoani.webapp.layers.model.Instructor;

import java.util.Set;

public interface InstructorService extends PersonService<Instructor> {

    InstructorDTO saveInstructor(InstructorDTO instructorDTO);

    void deleteInstructorById(Long id);

    boolean existsByEmail(String email);

    Set<Instructor> findAll();

    Instructor findById(Long id);

    InstructorDTO findDtoById(Long id);
}
