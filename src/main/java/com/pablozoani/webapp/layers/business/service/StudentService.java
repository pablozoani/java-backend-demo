package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.model.Student;

import java.util.Set;

public interface StudentService {

    Set<Student> findAll();

    StudentDTO saveStudent(StudentDTO student);

    Student findById(Long id);

    StudentDTO findDtoById(Long id);

    void deleteById(Long id);
}
