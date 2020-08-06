package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.AcademyDAO;
import com.pablozoani.webapp.layers.model.Academy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class AcademyServiceImpl implements AcademyService {

    private final AcademyDAO academyDAO;

    public AcademyServiceImpl(AcademyDAO academyDAO) { this.academyDAO = academyDAO; }

    public AcademyDTO saveAcademy(AcademyDTO dto) {

        log.debug("saveAcademy()");

        Academy academy = AcademyDTO.toEntity(dto);

        log.debug("detached academy id: " + academy.getId());

        Academy savedAcademy = academyDAO.save(academy);

        log.debug("persisted academy id: " + savedAcademy.getId());

        return AcademyDTO.toDTO(savedAcademy);
    }

    public Academy findById(Long id) {

        log.debug("findById() -> {}", id);

        return academyDAO
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Academy Not Found " + id));
    }

    public Set<Academy> findByNameContaining(String name) {

        log.debug("findByNameLike() -> {}", name);

        Set<Academy> output = new HashSet<>();

        academyDAO.findByNameContainingIgnoreCase(name)
                .forEach(output::add);

        return output;
    }

    public boolean existsByName(String name) { return academyDAO.existsByName(name); }

    public Set<Academy> findAll() {

        log.debug("findByAll()");

        Set<Academy> output = new HashSet<>();

        academyDAO.findAll()
                .forEach(output::add);

        return output;
    }

    public void deleteById(Long id) {

        log.debug("deleteById()");

        academyDAO.deleteById(id);
    }
}
