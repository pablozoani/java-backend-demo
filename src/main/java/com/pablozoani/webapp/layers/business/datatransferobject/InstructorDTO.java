package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Instructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class InstructorDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    private LocalDate registrationDate;

    private Set<CourseDTO> courses = new HashSet<>();

    public InstructorDTO(String firstName, String lastName, String email) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;
    }

    public static synchronized Instructor toEntity(InstructorDTO dto) {

        if (dto == null) return null;

        final Instructor instructor = new Instructor(dto.getFirstName(), dto.getLastName(), dto.getEmail());

        instructor.setId(dto.getId());

        instructor.setDateOfBirth(dto.getDateOfBirth());

        // instructor.setRegistrationDate(dto.getRegistrationDate());

        dto.getCourses()
           .forEach(courseDTO -> instructor.addCourse(CourseDTO.toEntity(courseDTO)));

        return instructor;
    }

    public static synchronized InstructorDTO toDTO(Instructor entity) {

        if (entity == null) return null;

        final InstructorDTO dto = new InstructorDTO(entity.getFirstName(), entity.getLastName(), entity.getEmail());

        dto.setId(entity.getId());

        dto.setDateOfBirth(entity.getDateOfBirth());

        dto.setRegistrationDate(entity.getRegistrationDate());

        entity.getCourses()
              .forEach(course -> dto.getCourses().add(CourseDTO.toDTO(course)));

        return dto;
    }
}
