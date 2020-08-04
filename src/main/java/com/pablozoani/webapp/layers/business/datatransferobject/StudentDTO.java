package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    private LocalDate registrationDate;

    private Set<CourseDTO> courses = new HashSet<>();

    public StudentDTO(String firstName, String lastName, String email) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;
    }

    public static synchronized Student toEntity(StudentDTO dto) {

        if (dto == null) return null;

        final Student student = new Student(dto.getFirstName(), dto.getLastName(), dto.getEmail());

        student.setId(dto.getId());

        student.setDateOfBirth(dto.getDateOfBirth());

        // student.setRegistrationDate(dto.getRegistrationDate());

        return student;
    }

    public static synchronized StudentDTO toDTO(Student entity) {

        if (entity == null) return null;

        final StudentDTO dto = new StudentDTO(entity.getFirstName(), entity.getLastName(), entity.getEmail());

        dto.setId(entity.getId());

        dto.setDateOfBirth(entity.getDateOfBirth());

        dto.setRegistrationDate(entity.getRegistrationDate());

        return dto;
    }
}
