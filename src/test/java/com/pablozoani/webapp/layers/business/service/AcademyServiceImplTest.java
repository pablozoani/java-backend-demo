package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.AcademyDAO;
import com.pablozoani.webapp.layers.model.Academy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.collections.Sets;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class AcademyServiceImplTest {

    AcademyService academyService;

    @Mock
    AcademyDAO academyDAO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        this.academyService = new AcademyServiceImpl(academyDAO);
    }

    @Test
    void saveAcademyTest() {

        AcademyDTO academyDTO = new AcademyDTO();

        academyDTO.setId(7L);

        when(academyDAO.save(any())).thenReturn(AcademyDTO.toEntity(academyDTO));

        AcademyDTO savedAcademyDTO = academyService.saveAcademy((academyDTO));

        assertEquals(academyDTO.getId(), savedAcademyDTO.getId());
    }

    @Test
    void findByIdTest() {

        Academy academy = new Academy("Science Academy");

        academy.setId(13L);

        when(academyDAO.findById(anyLong())).thenReturn(Optional.of(academy));

        Academy academyFound = academyService.findById(13L);

        assertEquals(academyFound.getId(), academy.getId());

        assertThrows(NotFoundException.class, () -> {

            when(academyDAO.findById(anyLong())).thenReturn(Optional.empty());

            academyService.findById(7L);
        });
    }

    @Test
    void findByNameContaining() {

        Academy academy = new Academy("Science Academy");

        academy.setId(13L);

        when(academyDAO.findByNameContainingIgnoreCase(anyString())).thenReturn(Sets.newSet(academy));

        Set<Academy> academies = academyService.findByNameContaining("Science");

        assertEquals(academies.size(), 1);

        assertEquals(academies.iterator().next().getId(), 13L);
    }

    @Test
    void findAllTest() {

        when(academyDAO.findAll()).thenReturn(Sets.newSet(new Academy("Science Academy")));

        Set<Academy> academies = academyService.findAll();

        assertEquals(academies.size(), 1);

        assertEquals("Science Academy", academies.iterator().next().getName());
    }

    @Test
    void deleteByIdTest() {

        academyService.deleteById(17L);

        verify(academyDAO, times(1)).deleteById(anyLong());
    }
}
