package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Instructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InstructorDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 255)
    private String lastName;

    @Email
    @NotBlank
    @Size(min = 3, max = 255)
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

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

        instructor.setRegistrationDate(dto.getRegistrationDate());

        return instructor;
    }

    public static synchronized InstructorDTO toDTO(Instructor entity) {

        if (entity == null) return null;

        final InstructorDTO dto = new InstructorDTO(entity.getFirstName(), entity.getLastName(), entity.getEmail());

        dto.setId(entity.getId());

        dto.setDateOfBirth(entity.getDateOfBirth());

        dto.setRegistrationDate(entity.getRegistrationDate());

        return dto;
    }

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
