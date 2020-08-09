package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.InstructorDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO instructorDAO) { this.instructorDAO = instructorDAO; }

    @Override
    public InstructorDTO saveInstructor(InstructorDTO instructorDTO) {

        log.debug("saveInstructor()");

        Instructor instructor = InstructorDTO.toEntity(instructorDTO);

        log.debug("detached instructor id: " + instructor.getId());

        Instructor savedInstructor = instructorDAO.save(instructor);

        log.debug("persisted academy id: " + savedInstructor.getId());

        return InstructorDTO.toDTO(savedInstructor);
    }

    @Override
    public Set<Instructor> findAll() {

        log.debug("findAll()");

        Set<Instructor> output = new HashSet<>();

        instructorDAO.findAll()
                .forEach(output::add);

        return output;
    }

    @Override
    public Instructor findById(Long id) {

        log.debug("findById() -> {}", id);

        return instructorDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Instructor Not Found " + id));
    }

    @Override
    public InstructorDTO findDtoById(Long id) {

        log.debug("findDtoById()");

        Instructor instructor = findById(id);

        return InstructorDTO.toDTO(instructor);
    }

    @Override
    public void deleteInstructorById(Long id) {

        log.debug("deleteInstructorById() -> {}", id);

        instructorDAO.deleteById(id);
    }
}
