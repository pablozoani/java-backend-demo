package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CourseDTO {

    private Long id;

    private String title;

    private AcademyDTO academy;

    private FieldOfStudy field;

    private InstructorDTO instructor;

    private Set<StudentDTO> students = new HashSet<>();

    public CourseDTO(String title, FieldOfStudy field, InstructorDTO instructor, AcademyDTO academy) {

        this.title = title;

        this.field = field;

        this.instructor = instructor;

        this.academy = academy;
    }

    public static synchronized Course toEntity(CourseDTO dto) {

        if (dto == null) return null;

        Instructor instructor = InstructorDTO.toEntity(dto.getInstructor());

        Academy academy = AcademyDTO.toEntity(dto.getAcademy());

        final Course entity = new Course(dto.getTitle(), dto.getField(), instructor, academy);

        entity.setId(dto.getId());

        return entity;
    }

    public static synchronized CourseDTO toDTO(Course entity) {

        if (entity == null) return null;

        InstructorDTO instructor = InstructorDTO.toDTO(entity.getInstructor());

        AcademyDTO academy = AcademyDTO.toDTO(entity.getAcademy());

        final CourseDTO dto = new CourseDTO(entity.getTitle(), entity.getField(), instructor, academy);

        dto.setId(entity.getId());

        entity.getStudents()
              .forEach(student -> dto.getStudents().add(StudentDTO.toDTO(student)));

        return dto;
    }
}