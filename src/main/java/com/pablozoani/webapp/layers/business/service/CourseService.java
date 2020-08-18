package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.CourseDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.model.Course;

import java.util.Set;

public interface CourseService {

    /**
     * Saves a course into the database.
     *
     * @param courseDTO dto representing
     * @return the saved dto
     */
    CourseDTO saveCourse(CourseDTO courseDTO);

    /**
     * Get all the courses in the database.
     *
     * @return the courses inside a set
     */
    Set<Course> findAll();

    /**
     * Find a courseDTO with the specified
     * id.
     *
     * @param id to find
     * @return found entity or null
     * @throws NotFoundException if the
     * given id is null
     */
    CourseDTO findDtoById(Long id);

    /**
     * Find a course with the specified
     * id.
     *
     * @param id to find
     * @return found entity or null
     * @throws NotFoundException if the
     * given id is null
     */
    Course findById(Long id);

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be null
     * @throws IllegalArgumentException
     * in case the given id is null
     */
    void deleteById(Long id);

    /**
     * Remove the student with the specified id
     * from the course with the specified id
     * 
     * @param courseId the id of the course
     * @param studentId the id of the student
     */
    void removeStudentById(Long courseId, Long studentId);

    /**
     * Add the student with the specified id to
     * the course with the specified id
     *
     * @param courseId the id of the course
     * @param studentId the id of the student
     */
    void addStudent(Long courseId, Long studentId);
}
