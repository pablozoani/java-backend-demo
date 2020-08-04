package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.model.Academy;

import java.util.Set;

public interface AcademyService {

    AcademyDTO saveAcademy(AcademyDTO dto);

    Academy findById(Long id);

    boolean existsByName(String name);

    Set<Academy> findByNameContaining(String name);

    Set<Academy> findAll();

    void deleteById(Long id);
}
