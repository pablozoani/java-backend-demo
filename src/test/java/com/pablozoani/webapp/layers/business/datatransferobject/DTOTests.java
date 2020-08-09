package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import com.pablozoani.webapp.layers.model.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.pablozoani.webapp.layers.model.base.FieldOfStudy.MATHEMATICS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DTOTests {

    @Test
    void academyDtoToEntity() {

        AcademyDTO academyDTO = new AcademyDTO("Math Academy");

        academyDTO.setId(7L);

        Academy academy = AcademyDTO.toEntity(academyDTO);

        assertEquals(academy.getName(), academyDTO.getName());

        assertEquals(7L, academy.getId());

        assertNull(AcademyDTO.toEntity(null));
    }

    @Test
    void academyEntityToDto() {

        Academy academy = new Academy("Math Academy");

        academy.setId(11L);

        AcademyDTO academyDTO = AcademyDTO.toDTO(academy);

        assertEquals(academy.getName(), academyDTO.getName());

        assertEquals(academy.getId(), academyDTO.getId());

        assertNull(AcademyDTO.toDTO(null));
    }

    @Test
    void instructorDtoToEntity() {

        InstructorDTO instructorDTO = new InstructorDTO("Leonhard", "Euler", "euler@secretnumber.com");

        instructorDTO.setId(13L);

        instructorDTO.setDateOfBirth(LocalDate.of(1707, 4, 15));

        Instructor instructor = InstructorDTO.toEntity(instructorDTO);

        assertEquals(13L, instructor.getId());

        assertEquals("Leonhard", instructor.getFirstName());

        assertEquals("Euler", instructor.getLastName());

        assertEquals("euler@secretnumber.com", instructor.getEmail());

        assertEquals(LocalDate.of(1707, 4, 15), instructor.getDateOfBirth());

        assertNull(InstructorDTO.toEntity(null));
    }

    @Test
    void instructorEntityToDto() {

        Instructor instructor = new Instructor("Leonhard", "Euler", "euler@secretnumber.com");

        instructor.setId(17L);

        instructor.setDateOfBirth(LocalDate.of(1707, 4, 15));

        InstructorDTO instructorDTO = InstructorDTO.toDTO(instructor);

        assertEquals(instructor.getId(), instructorDTO.getId());

        assertEquals(instructor.getFirstName(), instructorDTO.getFirstName());

        assertEquals(instructor.getLastName(), instructorDTO.getLastName());

        assertEquals(instructor.getEmail(), instructorDTO.getEmail());

        assertEquals(instructor.getDateOfBirth(), instructorDTO.getDateOfBirth());

        assertNull(InstructorDTO.toDTO(null));
    }

    @Test
    void studentDtoToEntity() {

        StudentDTO studentDTO = new StudentDTO("Amadeus", "Mozart", "piano@sonata.note");

        studentDTO.setId(19L);

        studentDTO.setDateOfBirth(LocalDate.of(1756, 1, 27));

        Student student = StudentDTO.toEntity(studentDTO);

        assertEquals(studentDTO.getId(), student.getId());

        assertEquals(studentDTO.getFirstName(), student.getFirstName());

        assertEquals(studentDTO.getLastName(), student.getLastName());

        assertEquals(studentDTO.getEmail(), student.getEmail());

        assertEquals(studentDTO.getDateOfBirth(), student.getDateOfBirth());

        assertNull(StudentDTO.toEntity(null));
    }

    @Test
    void studentEntityToDto() {

        Student student = new Student("Amadeus", "Mozart", "piano@sonata.note");

        student.setId(23L);

        student.setDateOfBirth(LocalDate.of(1756, 1, 27));

        StudentDTO studentDTO = StudentDTO.toDTO(student);

        assertEquals(student.getId(), studentDTO.getId());

        assertEquals(student.getFirstName(), studentDTO.getFirstName());

        assertEquals(student.getLastName(), studentDTO.getLastName());

        assertEquals(student.getEmail(), studentDTO.getEmail());

        assertEquals(student.getDateOfBirth(), studentDTO.getDateOfBirth());

        assertNull(StudentDTO.toDTO(null));
    }

    @Test
    void courseDtoToEntity() {

        AcademyDTO academyDTO = new AcademyDTO("Math Academy");

        academyDTO.setId(7L);

        InstructorDTO instructorDTO = new InstructorDTO("Leonhard", "Euler", "euler@secretnumber.com");

        instructorDTO.setId(13L);

        instructorDTO.setDateOfBirth(LocalDate.of(1707, 4, 15));

        CourseDTO courseDTO = new CourseDTO("Complex Numbers", MATHEMATICS, instructorDTO, academyDTO);

        courseDTO.setId(23L);

        Course course = CourseDTO.toEntity(courseDTO);

        assertEquals(23L, course.getId());

        assertEquals(courseDTO.getTitle(), course.getTitle());

        assertEquals(courseDTO.getField(), course.getField());

        assertEquals(courseDTO.getInstructor().getId(), course.getInstructor().getId());

        assertEquals(courseDTO.getAcademy().getId(), course.getAcademy().getId());
    }

    @Test
    void courseEntityToDto() {

        Academy academy = new Academy("Math Academy");

        academy.setId(7L);

        Instructor instructor = new Instructor("Leonhard", "Euler", "euler@secretnumber.com");

        instructor.setId(13L);

        instructor.setDateOfBirth(LocalDate.of(1707, 4, 15));

        Course course = new Course("Complex Numbers", MATHEMATICS, instructor, academy);

        course.setId(23L);

        CourseDTO courseDTO = CourseDTO.toDTO(course);

        assertEquals(23L, course.getId());

        assertEquals(courseDTO.getTitle(), course.getTitle());

        assertEquals(courseDTO.getField(), course.getField());

        assertEquals(courseDTO.getInstructor().getId(), course.getInstructor().getId());

        assertEquals(courseDTO.getAcademy().getId(), course.getAcademy().getId());
    }
}