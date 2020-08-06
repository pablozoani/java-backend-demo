package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.StudentDAO;
import com.pablozoani.webapp.layers.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) { this.studentDAO = studentDAO; }

    @Override
    public Set<Student> findAll() {

        log.debug("findAll()");

        Set<Student> output = new HashSet<>();

        studentDAO.findAll()
                .forEach(output::add);

        return output;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO student) {

        log.debug("saveStudent()");

        Student entity = StudentDTO.toEntity(student);

        log.debug("detached student id -> {}", entity.getId());

        entity = studentDAO.save(entity);

        log.debug("persistent student id -> {}", entity.getId());

        return StudentDTO.toDTO(entity);
    }

    @Override
    public Student findById(Long id) {

        log.debug("findById()");

        Optional<Student> studentOptional = studentDAO.findById(id);

        return studentOptional.orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    public StudentDTO findDtoById(Long id) {

        log.debug("findDtoById()");

        Student student = findById(id);

        return StudentDTO.toDTO(student);
    }

    @Override
    public void deleteById(Long id) {

        log.debug("deleteById() -> {}", id);

        studentDAO.deleteById(id);
    }
}
