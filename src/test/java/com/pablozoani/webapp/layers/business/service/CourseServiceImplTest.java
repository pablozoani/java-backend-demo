package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.business.datatransferobject.CourseDTO;
import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.AcademyDAO;
import com.pablozoani.webapp.layers.business.repository.CourseDAO;
import com.pablozoani.webapp.layers.business.repository.InstructorDAO;
import com.pablozoani.webapp.layers.business.repository.StudentDAO;
import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.collections.Sets;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CourseServiceImplTest {

    CourseService courseService;

    @Mock
    CourseDAO courseDAO;

    @Mock
    InstructorDAO instructorDAO;

    @Mock
    AcademyDAO academyDAO;

    @Mock
    StudentDAO studentDAO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        courseService = new CourseServiceImpl(courseDAO, instructorDAO, academyDAO, studentDAO);
    }

    @Test
    void saveCourse() {

        CourseDTO courseDTO = new CourseDTO();

        AcademyDTO academyDTO = new AcademyDTO();

        academyDTO.setId(23L);

        InstructorDTO instructorDTO = new InstructorDTO();

        instructorDTO.setId(29L);

        courseDTO.setAcademy(academyDTO);

        courseDTO.setInstructor(instructorDTO);

        Course course = new Course("Object Oriented Programming", FieldOfStudy.COMPUTER_SCIENCE,
                new Instructor("Silvester", "Pitt", "silvester@example.com"),
                new Academy("Computer Science Academy"));

        when(courseDAO.save(any())).thenReturn(course);

        when(instructorDAO.findById(anyLong())).thenReturn(Optional.of(course.getInstructor()));

        when(academyDAO.findById(anyLong())).thenReturn(Optional.of(course.getAcademy()));

        CourseDTO savedCourseDTO = courseService.saveCourse(courseDTO);

        assertEquals(savedCourseDTO.getTitle(), "Object Oriented Programming");

        verify(courseDAO, times(1)).save(any());

        verify(instructorDAO, times(1)).findById(anyLong());

        verify(academyDAO, times(1)).findById(anyLong());
    }

    @Test
    void findAll() {

        Course course = new Course("Object Oriented Programming", FieldOfStudy.COMPUTER_SCIENCE,
                new Instructor("Silvester", "Pitt", "silvester@example.com"),
                new Academy("Computer Science Academy"));

        when(courseDAO.findAll()).thenReturn(Sets.newSet(course));

        Set<Course> courses = courseService.findAll();

        assertEquals(1, courses.size());

        assertEquals("Object Oriented Programming", courses.iterator().next().getTitle());

        verify(courseDAO, times(1)).findAll();
    }
    @Test
    void findById() {

        Course course = new Course("Object Oriented Programming", FieldOfStudy.COMPUTER_SCIENCE,
                new Instructor("Silvester", "Pitt", "silvester@example.com"),
                new Academy("Computer Science Academy"));

        course.setId(13L);

        when(courseDAO.findById(anyLong())).thenReturn(Optional.of(course));

        Course courseFound = courseService.findById(13L);

        assertEquals(courseFound.getId(), course.getId());

        assertThrows(NotFoundException.class, () -> {

            when(courseDAO.findById(anyLong())).thenReturn(Optional.empty());

            courseService.findById(7L);
        });
    }

    @Test
    void deleteById() {

        courseService.deleteById(31L);

        verify(courseDAO, times(1)).deleteById(anyLong());
    }
}