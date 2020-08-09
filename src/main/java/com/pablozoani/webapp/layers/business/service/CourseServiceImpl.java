package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.CourseDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.AcademyDAO;
import com.pablozoani.webapp.layers.business.repository.CourseDAO;
import com.pablozoani.webapp.layers.business.repository.InstructorDAO;
import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;

    private final InstructorDAO instructorDAO;

    private final AcademyDAO academyDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO,
                             InstructorDAO instructorDAO,
                             AcademyDAO academyDAO) {

        this.courseDAO = courseDAO;

        this.instructorDAO = instructorDAO;

        this.academyDAO = academyDAO;
    }

    @Transactional
    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {

        log.debug("saveCourse()");

        Course entity = CourseDTO.toEntity(courseDTO);

        Long academyId = courseDTO.getAcademy().getId();

        log.debug("academy id -> {}", academyId);

        Optional<Academy> academyOptional = academyDAO.findById(academyId);

        Academy academy = academyOptional.orElseThrow(() ->
                new NotFoundException("Academy was not found"));

        Long instructorId = courseDTO.getInstructor().getId();

        log.debug("instructor id -> {}", instructorId);

        Optional<Instructor> instructorOptional = instructorDAO.findById(instructorId);

        Instructor instructor = instructorOptional.orElseThrow(() ->
                new NotFoundException("Instructor was not found"));

        log.debug("detached entity id -> {}", entity.getId());

        entity.setAcademy(academy);

        entity.setInstructor(instructor);

        entity = courseDAO.save(entity);

        log.debug("persisted entity id -> {}", entity.getId());

        courseDTO = CourseDTO.toDTO(entity);

        return courseDTO;
    }

    @Override
    public Set<Course> findAll() {

        log.debug("findAll()");

        Set<Course> output = new HashSet<>();

        courseDAO.findAll()
                .forEach(output::add);

        return output;
    }

    @Override
    public Course findById(Long id) {

        log.debug("findById() -> {}", id);

        return courseDAO.findById(id).orElseThrow(() ->
                new NotFoundException("Course Not Found " + id));
    }

    @Override
    public void deleteById(Long id) {

        log.debug("deleteById() -> {}", id);

        courseDAO.deleteById(id);
    }

    @Override
    public CourseDTO findDtoById(Long id) {

        Course entity = findById(id);

        return CourseDTO.toDTO(entity);
    }
}
