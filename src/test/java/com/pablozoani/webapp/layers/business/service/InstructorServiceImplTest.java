package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.InstructorDAO;
import com.pablozoani.webapp.layers.model.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class InstructorServiceImplTest {

    InstructorService instructorService;

    @Mock
    InstructorDAO instructorDAO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        instructorService = new InstructorServiceImpl(instructorDAO);
    }

    @Test
    void saveInstructor() {

        InstructorDTO instructorDTO = new InstructorDTO();

        instructorDTO.setId(7L);

        when(instructorDAO.save(any())).thenReturn(InstructorDTO.toEntity(instructorDTO));

        InstructorDTO savedInstructor = instructorService.saveInstructor(instructorDTO);

        assertEquals(7L, savedInstructor.getId());
    }

    @Test
    void findAll() {

        Instructor instructor = new Instructor("Brad", "Stallone", "bstallone@email.com");

        Set<Instructor> instructors = new HashSet<>();

        instructors.add(instructor);

        when(instructorDAO.findAll()).thenReturn(instructors);

        instructors = instructorService.findAll();

        assertEquals(1, instructors.size());

        assertEquals(instructor.getFirstName(), instructors.iterator().next().getFirstName());
    }

    @Test
    void findById() {

        Instructor instructor = new Instructor("Brad", "Stallone", "bstallone@email.com");

        instructor.setId(5L);

        when(instructorDAO.findById(anyLong())).thenReturn(Optional.of(instructor));

        Instructor instructorFound = instructorService.findById(5L);

        assertEquals(instructorFound.getId(), instructor.getId());

        assertThrows(NotFoundException.class, () -> {

            when(instructorDAO.findById(anyLong())).thenReturn(Optional.empty());

            instructorService.findById(5L);
        });
    }

    @Test
    void findDtoById() {

        Instructor instructor = new Instructor("Brad", "Stallone", "bstallone@email.com");

        instructor.setId(3L);

        when(instructorDAO.findById(anyLong())).thenReturn(Optional.of(instructor));

        InstructorDTO instructorDtoFound = instructorService.findDtoById(3L);

        assertEquals(3L, instructorDtoFound.getId());

        verify(instructorDAO, times(1)).findById(anyLong());
    }

    @Test
    void deleteInstructorById() {

        instructorService.deleteInstructorById(2L);

        verify(instructorDAO, times(1)).deleteById(anyLong());
    }
}