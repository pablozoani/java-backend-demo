package com.pablozoani.webapp.layers.business.service;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import com.pablozoani.webapp.layers.business.repository.StudentDAO;
import com.pablozoani.webapp.layers.model.Student;
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

class StudentServiceImplTest {

    StudentService studentService;

    @Mock
    StudentDAO studentDAO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        studentService = new StudentServiceImpl(studentDAO);
    }

    @Test
    void findAll() {

        Student student = new Student("Sandra", "Clooney", "sclooney@email.com");

        Set<Student> students = new HashSet<>();

        students.add(student);

        when(studentDAO.findAll()).thenReturn(students);

        students = studentService.findAll();

        assertEquals(1, students.size());

        assertEquals(student.getFirstName(), students.iterator().next().getFirstName());
    }

    @Test
    void saveStudent() {

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(7L);

        when(studentDAO.save(any())).thenReturn(StudentDTO.toEntity(studentDTO));

        StudentDTO savedStudent = studentService.saveStudent(studentDTO);

        assertEquals(7L, savedStudent.getId());
    }

    @Test
    void findById() {

        Student student = new Student("Sandra", "Clooney", "sclooney@email.com");

        student.setId(5L);

        when(studentDAO.findById(anyLong())).thenReturn(Optional.of(student));

        Student studentFound = studentService.findById(5L);

        assertEquals(studentFound.getId(), student.getId());

        assertThrows(NotFoundException.class, () -> {

            when(studentDAO.findById(anyLong())).thenReturn(Optional.empty());

            studentService.findById(5L);
        });
    }

    @Test
    void findDtoById() {

        Student student = new Student("Sandra", "Clooney", "sclooney@email.com");

        student.setId(3L);

        when(studentDAO.findById(anyLong())).thenReturn(Optional.of(student));

        StudentDTO studentDTOFound = studentService.findDtoById(3L);

        assertEquals(3L, studentDTOFound.getId());

        verify(studentDAO, times(1)).findById(anyLong());
    }

    @Test
    void deleteById() {

        studentService.deleteById(2L);

        verify(studentDAO, times(1)).deleteById(anyLong());
    }
}