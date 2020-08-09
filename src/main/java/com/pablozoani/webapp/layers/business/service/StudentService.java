package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.business.service.base.PersonService;
import com.pablozoani.webapp.layers.model.Student;

public interface StudentService extends PersonService<Student> {

    /**
     * Save a student DTO into the database.
     *
     * @param student dto to be saved
     * @return the saved instance
     */
    StudentDTO saveStudent(StudentDTO student);

    /**
     * Find a student dto whose id is equal
     * to param.
     *
     * @param id of the student
     * @return the student dto instance
     */
    StudentDTO findDtoById(Long id);

    /**
     * Delete a student whose id is equal to
     * param
     *
     * @param id of the student
     */
    void deleteById(Long id);
}
